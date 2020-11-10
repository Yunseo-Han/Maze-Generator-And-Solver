package dang.han.cs146.project3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import dang.han.cs146.project3.Node.Status;

public class BFS {
	
	Queue<Node> queue = new LinkedList<>();
	
	/*
	 * This method implements Breadth-First Search. 
	 * 
	 * NOTE: NOT FINISHED. HAVE NOT FIGURED OUT HOW TO GET THE SHORTEST PATH
	 */
	void search(Node[][] maze, Node source) {
		//initialize vertices 
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze.length; col++) {
				Node currNode = maze[row][col];
				currNode.discoverStatus = Status.UNDISCOVERED;
				currNode.distance = Integer.MAX_VALUE;
				currNode.predecessor = null;
			}
		}
		source.discoverStatus = Status.VISITED;
		source.distance = 0;
		source.predecessor = null;
		queue.add(source);
		
		while(queue.size() != 0) {
			Node exploredNode = queue.remove();
			ArrayList<Node> currNodeConnections = exploredNode.connections;
			for (int i = 0; i < currNodeConnections.size(); i++) {
				Node currNode = currNodeConnections.get(i);
				if (currNode.discoverStatus == Status.UNDISCOVERED) {
					currNode.setStatus(Status.VISITED);
					currNode.setDistance(exploredNode.distance + 1);
					currNode.setPredecessor(exploredNode);
					queue.add(currNode);
				}
			}
			exploredNode.setStatus(Status.EXPLORED);
		}
	}
}
