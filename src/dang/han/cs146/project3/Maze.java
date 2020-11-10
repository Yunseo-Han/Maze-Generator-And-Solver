package dang.han.cs146.project3;

import java.util.ArrayList;

import dang.han.cs146.project3.Node.Status;

public class Maze {
	
	
	int pathLength;
	int visitedCells;
	Node[][] maze;
	
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
