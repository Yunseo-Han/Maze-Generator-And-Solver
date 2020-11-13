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
	
	public Maze(int size) {
		this.size = size;
		maze = new Node[size][size];
		initializeMaze();
	}
	
	/**
	 * Initializes all nodes in maze[][].
	 */
	void initializeMaze() {
		Node currNode;
		
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				maze[i][j] = new Node(i, j);
				currNode = maze[i][j];
				currNode.setStatus(Status.UNDISCOVERED);
				currNode.distance = Integer.MAX_VALUE;
				currNode.predecessor = null;
			}
		}
	}
	
	/*
	 * Removes the wall between two Nodes and adds each other to their ArrayList<Node> connections
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
	private List<Node> findNeighbors(Node node){
		
		List<Node> neighbors = new ArrayList<>();
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
	
	
	
	// Create a maze with r*r rooms
	// NOTE: UNFINISHED 
	public void createMaze(int size) {
		Stack<Node> cellStack = new Stack<>();
		int totalCells = size*size;
		Node currentCell = maze[0][0];
		int visitedCells = 1;
		
		
		while (visitedCells < totalCells) {
			// find all neighbors of CurrentCell with all walls intact
			List<Node> neighbors = findNeighbors(currentCell);
			List<Node> wallsIntact = new ArrayList<>();
			for (int i=0; i<neighbors.size(); i++) {
				if (neighbors.get(i).allWallsIntact()) {
					wallsIntact.add(neighbors.get(i));
				}
				
			// if one or more found, choose one Node at random
				if (wallsIntact.size() > 0) {
					Random rand = new Random();
					rand.setSeed(20);	// helps generate the same "random" maze
					int randValue = rand.nextInt(neighbors.size());
					
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
				else {
					//pop the most recent cell entry off the Cell Stack
					//make it Current Cell
					currentCell = cellStack.pop();
				}
						
			}
		}
	}
	
	/*
	 * Prints ASCII of the maze.
	 */
	
	public void printMaze() {
		
		String[][] charMaze = new String[size*2-1][size*2-1];
		
		for (int row = 0; row < charMaze.length; row++) {
			for (int col = 0; col < charMaze.length; col++) {
				
				// "even" rows
				if (row%2 == 0) {
					if (col%2 == 0) {
						charMaze[row][col] = "+";
					} else {
						charMaze[row][col] = "-";
					}
				}
				
				// odd rows
				if (row%2 == 1) {
					if (col%2 == 0) {
						charMaze[row][col] = "|";
					} else {
						charMaze[row][col] = " ";
					}
				}
				
				charMaze[0][1] = " ";
				System.out.print(charMaze[row][col]);
				
			}
			System.out.println(" ");
		}
		
	}
	
	
		
	
	/*
	 * Enough walls must be removed so that every room (therefore also
	 * the finishing room) is reachable from the starting room. 
	 * 
	 * This method uses BFS to check the discovery status of each node.
	 * It will return false if a Node in the maze is undiscovered. 
	 * @ return whether the maze is fully connected or not
	 * 
	 * NOTE: HAS NOT BEEN TESTED YET
	 * 
	 */
	public boolean fullyConnected(Node [][] maze) {
		BFS bfs = new BFS();
		bfs.solveMaze(maze, maze[0][0], maze[maze.length-1][maze[0].length-1]);	// not sure if adding discovery node ruins the code
		boolean isFullyConnected = true;
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze.length; col++) {
				if (maze[row][col].discoverStatus == Status.UNDISCOVERED) {
					isFullyConnected = false;
				}
			}
		}
		return isFullyConnected;
	}
	
	
}
