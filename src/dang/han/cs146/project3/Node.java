package dang.han.cs146.project3;


import java.util.ArrayList;


/**
 * A node class meant to represent each cell in the maze. Empty walls represented by connections in north, south, east, or west. 
 * @author yunseo
 *
 */
public class Node {
	
	enum Status {
		UNDISCOVERED, VISITED, EXPLORED;
	}
	private int row;
	private int col;
	private Node north;
	private Node south;
	private Node east;
	private Node west;
	ArrayList<Node> connections;
	Status discoverStatus;
	
	//BFS properties
	Node predecessor; 
	int distance;
	
	//DFS properties 
	private int discoverTime;
	private int finishTime;
	
	
	public Node(int row, int col) {
		this.row = row;
		this.col = col;
		this.north = null;
		this.south = null;
		this.east = null;
		this.west = null;
		discoverStatus = Status.UNDISCOVERED;
		predecessor = null;
	}
	
	
	public void connectNorth(Node cell) {
		this.north = cell;
		connections.add(cell);
	}
	
	
	public void connectSouth(Node cell) {
		this.south = cell;
		connections.add(cell);
	}
	
	
	public void connectEast(Node cell) {
		this.east = cell;
		connections.add(cell);
	}
	
	
	public void connectWest(Node cell) {
		this.west = cell;
		connections.add(cell);
	}
	
	public ArrayList<Node> getConnections() {
		return new ArrayList<>(connections);
	}
	
	public boolean isConntectedTo(Node that) {
		if (this.getConnections().contains(that)) {
			return true;
		} return false;
	}
	
	public void setStatus(Status discoverStatus) {
		this.discoverStatus = discoverStatus;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public void setPredecessor(Node cell) {
		predecessor = cell;
	}
	
}
