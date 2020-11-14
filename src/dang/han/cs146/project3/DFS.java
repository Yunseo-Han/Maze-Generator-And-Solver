package dang.han.cs146.project3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import dang.han.cs146.project3.Node.Status;

public class DFS {
	private Stack<Node> cellStack = new Stack<>();
	private List<Node> path = new ArrayList<>();
	
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
					cellStack.push(nextCell);
				}		
			}
			
			currentCell.setStatus(Status.EXPLORED);	// or maybe these three lines need to go in the front
			currentCell.setFinishTime(step);
			step++;
		}
	}

}

