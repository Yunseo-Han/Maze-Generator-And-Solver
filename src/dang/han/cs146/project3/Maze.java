package dang.han.cs146.project3;

import dang.han.cs146.project3.Node.Status;

public class Maze {
	
	
	int pathLength;
	int visitedCells;
	Node [][] maze;
	
	// Create a maze with r*r rooms
	// NOTE: UNFINISHED 
	public void createMaze(int size) {
		maze = new Node [size][size];
		// Randomized wall removal 
		
		// 
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
		bfs.search(maze, maze[0][0]);
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
