package dang.han.cs146.project3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import dang.han.cs146.project3.Node.Status;

public class BFS {
	
	Queue<Node> queue = new LinkedList<>();
	ArrayList<Node> shortestPath = new ArrayList<>();
	ArrayList<Node>	truePath = new ArrayList<>();		//******************************************* keeps track of every node visited 
	
	/**
	 * implementes Breadth-First Search to find the shortest shortestPath from source Node to destination Node. 
	 * @param maze, 2D representation of the maze 
	 * @param source, starting point/Node 
	 * @param destination, ending point/Node
	 */
	void solveMaze(Node[][] maze, Node source, Node destination) {
		/*
		//initialize all vertices 
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze.length; col++) {
				Node currNode = maze[row][col];
				currNode.discoverStatus = Status.UNDISCOVERED;
				currNode.step = Integer.MAX_VALUE;
				currNode.predecessor = null;
			}
		}	// Note: this can be done in the maze class initializeMaze()
		*/
		
		source.discoverStatus = Status.VISITED;	
		source.step = 0;
		source.predecessor = null;
		queue.add(source);
		truePath.add(source);		//*****************************************
		int step = 1;
		
		
		// Queue has BFS order 
		while(queue.size() != 0) {
			Node exploredNode = queue.remove();
			ArrayList<Node> currNodeConnections = exploredNode.adjList;
			for (int i = 0; i < currNodeConnections.size(); i++) {
				Node currNode = currNodeConnections.get(i);
				if (currNode.discoverStatus == Status.UNDISCOVERED && currNode.discoverStatus != Status.VISITED) {
					currNode.setStatus(Status.VISITED);
					currNode.setStep(step++);
					truePath.add(currNode);		//**************************************************
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
	
	/**
	 * Recursively prints and stores the "(row, col)" for each Node in the shortest shortestPath in the correct order.
	 * @param source
	 * @param destination
	 */
	void findShortestPath(Node[][]maze, Node source, Node destination) {
		if (destination.equals(source)) {	//base case, source node
			System.out.print(source.getLocation());
			shortestPath.add(source);
		} else if (destination.predecessor == null) {
			System.out.print("no shortestPath from" + source + " to " + destination + "exists");
		} else {
			findShortestPath(maze, source, destination.predecessor);	//print the predecessor
			shortestPath.add(destination);
			System.out.print(destination.getLocation());
		}
	}
	
	ArrayList<Node> getPath() {
		return shortestPath;
	}
	
	
}
