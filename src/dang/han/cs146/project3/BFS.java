package dang.han.cs146.project3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import dang.han.cs146.project3.Node.Status;

public class BFS {
	
	Queue<Node> queue = new LinkedList<>();
	ArrayList<Node> path = new ArrayList<>();
	
	/*
	 * This method implementes Breadth-First Search to find the shortest path from source Node to destination Node. 
	 * @param maze, 2D representation of the maze 
	 * @param source, starting point/Node 
	 * @param destination, ending point/Node
	 */
	void solveMaze(Node[][] maze, Node source, Node destination) {
		
		//initialize all vertices 
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze.length; col++) {
				Node currNode = maze[row][col];
				currNode.discoverStatus = Status.UNDISCOVERED;
				currNode.distance = Integer.MAX_VALUE;
				currNode.predecessor = null;
			}
		}	// Note: this can be done in the maze class initializeMaze()
		source.discoverStatus = Status.VISITED;	
		source.distance = 0;
		source.predecessor = null;
		queue.add(source);
		
		// Queue has BFS order 
		while(queue.size() != 0) {
			Node exploredNode = queue.remove();
			ArrayList<Node> currNodeConnections = exploredNode.adjList;
			for (int i = 0; i < currNodeConnections.size(); i++) {
				Node currNode = currNodeConnections.get(i);
				if (currNode.discoverStatus == Status.UNDISCOVERED) {
					currNode.setStatus(Status.VISITED);
					currNode.setDistance(exploredNode.distance + 1);
					currNode.setPredecessor(exploredNode);
					queue.add(currNode);
					// destination found
					if (currNode == destination) {
						return;
					}
				}
			}
			exploredNode.setStatus(Status.EXPLORED);
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
