package dang.han.cs146.project3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import dang.han.cs146.project3.Node.Status;

public class DFS {
	private Stack<Node> cellStack = new Stack<>();
	ArrayList<Node> path = new ArrayList<>();
	
	/**
	 * solves maze using DFS iterative algorithm
	 * @param maze
	 * @param source
	 * @param destination
	 */
	public void solveMaze(Node[][] maze) {
		Node destination = maze[maze.length-1][maze.length-1];
		Node currentCell = maze[0][0];
		int step = 0;

		currentCell.setStatus(Status.VISITED);
		currentCell.setDiscoverTime(step);
		step++;
		cellStack.push(currentCell);
		
		while (!cellStack.empty()) {
			currentCell = cellStack.pop();
			path.add(currentCell);
			if (currentCell == destination) {	// maybe this has to go in the end
				return;
			}
			
			List<Node> currAdjList = currentCell.adjList;
			
			// add all undiscovered connections of currentCell to stack
			for (int i=0; i<currAdjList.size(); i++) {
				Node nextCell = currAdjList.get(i);
				if(nextCell.discoverStatus == Status.UNDISCOVERED) {
					nextCell.setStatus(Status.VISITED);
					nextCell.setDiscoverTime(step);
					step++;
					nextCell.setPredecessor(currentCell);
					cellStack.push(nextCell);
				}		
			}
			
			currentCell.setStatus(Status.EXPLORED);	// or maybe these three lines need to go in the front
			step++;
		}
	}
	
	/*
	 * Recursively prints and stores the "(row, col)" for each Node in the shortest path in the correct order.
	 * @param source
	 * @param destination
	 */
	void findShortestPath(Node[][]maze, Node source, Node destination) {
		if (destination.equals(source)) {	//base case, source node
			System.out.print(source.getLocation());
			path.add(source);
		} else if (destination.predecessor == null) {
			System.out.print("no path from" + source + " to " + destination + "exists");
		} else {
			findShortestPath(maze, source, destination.predecessor);	//print the predecessor
			path.add(destination);
			System.out.print(destination.getLocation());
		}
	}
	
	ArrayList<Node> getPath() {
		return path;
	}

}

