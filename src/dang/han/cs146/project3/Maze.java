package dang.han.cs146.project3;

import java.util.ArrayList;

import dang.han.cs146.project3.Node.Status;

public class Maze {
	
	int pathLength;
	int visitedCells;
	
	Node[][] maze;
	private int size;
	
	public Maze(int size) {
		this.size = size;
		maze = new Node[size][size];
	}
	
	
	/**
	 * connects cells together with consideration of the parameter cells
	 * so the cells are properly connected according to their position but the walls are still up
	 */
	private void setNeighbors() {
		
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				maze[i][j] = new Node(i, j);	// maybe i+1 and j+1 for node position idk probs not
				
				// if statements below checks if the neighbor being added is a cell that exists to account for edges of the maze
				
				// north cell
				if (checkCell(i, j-1)) {
					maze[i][j].connections.add(maze[i][j-1]);
				}
				// south cell
				if (checkCell(i, j+1)) {
					maze[i][j].connections.add(maze[i][j+1]);
				}
				// west cell
				if (checkCell(i-1, j)) {
					maze[i-1][j].connections.add(maze[i-1][j]);
				}
				if (checkCell(i+1, j)) {
					maze[i+1][j].connections.add(maze[i+1][j]);
				}
			}
		}
	}
	
	/**
	 * checks if the cell being added as neighbor is valid
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
	// https://www.youtube.com/watch?v=SqqOB2HgGsM&ab_channel=JonnyFosnight
	public void createMaze(int size) {
		maze = new Node[size][size];
		int totalCells = size*size;
		Node currentCell = maze[0][0];
		int visitedCells = 1;
		
		while (visitedCells < totalCells) {
			ArrayList<Node> wallsIntact = new ArrayList<>();
			for (int i=0; i<currentCell.connections.size(); i++) {
				if (currentCell.connections.get(i).allWallsIntact()) {
					wallsIntact.add(currentCell.connections.get(i));
				}	
				// "if one or more found choose one at RANDOM"?? can I just choose the first one?
				if (wallsIntact.size() > 0) {
					
				}
				
			}
		}
		
		// review: create a graph that has 3 connections on the perimeter nodes and 4 connections inside
			// how to keep track of which cell (node) belong in which direction 
				// each cell needs a row number and column number
				// create each cell with row and column using nested for loop
		// stack use 
		
	}
	
	public void connectHorizontal(Node right, Node left) {
		right.connectEast(left);
		left.connectWest(right);
	}
	
	public void connectVertical(Node top, Node bottom) {
		top.connectSouth(bottom);
		bottom.connectNorth(top);
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
		bfs.search(maze, maze[0][0], maze[maze.length-1][maze[0].length-1]);	// not sure if adding discovery node ruins the code
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
