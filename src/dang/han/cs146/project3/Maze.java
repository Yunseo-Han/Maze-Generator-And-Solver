package dang.han.cs146.project3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import dang.han.cs146.project3.Node.Status;

public class Maze {
	
	int pathLength;
	int visitedCells;
	
	Node[][] maze;
	int size;
	Random rand; 
	
	
	// might have to create a helper method for converting row, col from charmaze to maze 
	
	
	
	public Maze(int size) {
		this.size = size;
		maze = new Node[size][size];
		initializeMaze();
		rand = new Random();
		rand.setSeed(10);	// helps generate the same "random" maze
	}
	
	
	/**
	 * creates a maze with size*size cells
	 */
	public void createMaze() {
		Stack<Node> cellStack = new Stack<>();
		int totalCells = size*size;
		Node currentCell = maze[0][0];
		int visitedCells = 1;
		
		while (visitedCells < totalCells) {

			ArrayList<Node> neighbors = findNeighbors(currentCell);
			ArrayList<Node> wallsIntact = new ArrayList<>();
			
			// find all neighbors of CurrentCell with all walls intact
			for (int i=0; i<neighbors.size(); i++) {
				if (neighbors.get(i).allWallsIntact()) {
					wallsIntact.add(neighbors.get(i));
				}							
			}
			
			// if one or more found, choose one Node at random
			if (wallsIntact.size() > 0) {
				
				int randValue = rand.nextInt(wallsIntact.size());					
				Node randCell = wallsIntact.get(randValue);
				// knock down the wall between it and CurrentCell
				removeWall(randCell, currentCell);
				
				// push CurrentCell location on the CellStack
				cellStack.push(currentCell);
				
				// make the new cell CurrentCell
				currentCell = randCell;
				
				// add 1 to Visited Cells
				visitedCells++;
			}
			else if (cellStack.size() != 0){
				//pop the most recent cell entry off the Cell Stack
				//make it Current Cell
				currentCell = cellStack.pop();
			}
			
		}
	}
	
	
	
	/**
	 * creates a string visualization of this empty maze
	 * @return a string visualization of this empty maze
	 */
	public String[][] stringMaze() {
		
		String[][] charMaze = new String[size*2+1][size*2+1];
				
		for (int row = 0; row < charMaze.length; row++) {
			for (int col = 0; col < charMaze.length; col++) {
				
				// "even" rows
				if (row%2 == 0) {
					if (col%2 == 0) {	
						charMaze[row][col] = "+";
					} 
					else if (row == charMaze.length-1){		// bottom row of walls all gets printed
						charMaze[row][col] = "-";
					}
					else {	// case: row is odd and is not the last row
						
						// calculate the maze cell equivalent position of this wall (top wall of cell) 
						// wall (0, 1) == cell (0, 0) => (1+1)/2-1=0 ; wall (4, 5) == cell (2, 2) => (5+1)/2-1=2 
						int mazeRowIndex = row/2;							
						int mazeColIndex = (col+1)/2 -1;
						
						if (this.maze[mazeRowIndex][mazeColIndex].hasNorthWall) {
							charMaze[row][col] = "-";
						}
						else {
							charMaze[row][col] = " ";	
						}
					}	
				}
				
				// odd rows
				if (row%2 == 1) {
					if (col%2 == 0 && col==charMaze.length-1) {		// last column of walls all gets printed
						charMaze[row][col] = "|";
					} 
					else if (col%2 == 0) {		// case: column is even and is not the last row
						int mazeRowIndex = (row+1)/2-1;							
						int mazeColIndex = col/2;
						
						if (this.maze[mazeRowIndex][mazeColIndex].hasWestWall) {
							charMaze[row][col] = "|";
						}
						else {
							charMaze[row][col] = " ";	
						}
					}
					else {
						charMaze[row][col] = " ";	// will be replaced with numbers and #
					}
				}
			}
		}
		
		charMaze[0][1] = " ";
		charMaze[charMaze.length-1][charMaze.length-2] = " ";
		
		return charMaze;
	}
	
	
	
	/**
	 * adds path numbers to the stringMaze
	 * @param path	ArrayList<Node> containing the path taken to solve this maze 
	 * @param charMaze	a string visualization of this maze
	 * @return	a string visualization of this maze with the numbered solving steps 
	 */
	public String[][] mazeSteps(ArrayList<Node> path, String[][] stringMaze) {
		int charRow = -1;
		int charCol = -1;
		
		String[][] temp = stringMaze;
		for (int i=0; i<path.size(); i++) {
			Node currNode = path.get(i);
			charRow = currNode.row*2+1;
			charCol = currNode.col*2+1;
			
			temp[charRow][charCol] = Integer.toString(currNode.step%10);
		}
		
		return temp;
	}
	
	
	
	public String[][] mazeHash(ArrayList<Node> shortestPath, String[][] stringMaze){
		int charRow = -1;
		int charCol = -1;
		
		for (int i=0; i<shortestPath.size(); i++) {
			Node currNode = shortestPath.get(i);
			charRow = currNode.row*2+1;
			charCol = currNode.col*2+1;
			
			stringMaze[charRow][charCol] = "#";
		}
		
		return stringMaze;
	}
	
	
	
	/**
	 * prints the string version of this maze 
	 * @param charMaze	a string visualization of this maze
	 */
	public void printMaze(String[][] charMaze) {
		for (int row = 0; row < charMaze.length; row++) {
			for (int col = 0; col < charMaze.length; col++) {
				System.out.print(charMaze[row][col]);
			}
			System.out.println(" ");
		}
	}
	
	
	
	/**
	 * Initialize all nodes in maze[][] by assigning i and j indexes.
	 */
	private void initializeMaze() {
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				maze[i][j] = new Node(i, j);
			}
		}
	}
	
	
	
	/**
	 * Removes the wall between two Nodes and adds each other to their ArrayList<Node> connections
	 * @param thisNode
	 * @param thatNode
	 */
	void removeWall(Node thisNode, Node thatNode) {
		thisNode.removeWallBtwn(thatNode);
		thatNode.removeWallBtwn(thisNode);
	}
	
	
	
	/**
	 * finds all the neighbors of given node
	 * @param node
	 * @return an arraylist of neighboring nodes
	 */
	ArrayList<Node> findNeighbors(Node node){
		
		ArrayList<Node> neighbors = new ArrayList<>();
		// if statements below checks if the neighbor being added is a cell that exists to account for edges of the maze
		
		// north cell
		if (checkCell(node.row, node.col-1)) {
			neighbors.add(maze[node.row][node.col-1]);
		}
		// south cell
		if (checkCell(node.row, node.col+1)) {
			neighbors.add(maze[node.row][node.col+1]);
		}
		// west cell
		if (checkCell(node.row-1, node.col)) {
			neighbors.add(maze[node.row-1][node.col]);
		}
		// east cell
		if (checkCell(node.row+1, node.col)) {
			neighbors.add(maze[node.row+1][node.col]);
		}
		
		return neighbors;
	}
	
	
	
	/**
	 * checks if the cell valid. cells are not valid if its index is negative or larger than maze size
	 * @param i 
	 * @param j
	 * @return true if cell is safe to be added as a neighbor
	 */
	private boolean checkCell(int i, int j) {
		if (i<0 || i>(size-1) || j<0 || j>(size-1)) {
			return false;
		}
		return true;
	}
	
	
}
