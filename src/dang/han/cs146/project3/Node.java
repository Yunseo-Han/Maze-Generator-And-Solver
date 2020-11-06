package dang.han.cs146.project3;

/**
 * A node class meant to represent each cell in the maze. Empty walls represented by connections in north, south, east, or west. 
 * @author yunseo
 *
 */
public class Node {
	private int data;
	private Node north;
	private Node south;
	private Node east;
	private Node west;
	
	
	public Node(int data) {
		this.data = data;
		this.north = null;
		this.south = null;
		this.east = null;
		this.west = null;
	}
	
	
	public void connectNorth(Node cell) {
		this.north = cell;
	}
	
	
	public void connectSouth(Node cell) {
		this.south = cell;
	}
	
	
	public void connectEast(Node cell) {
		this.east = cell;
	}
	
	
	public void connectWest(Node cell) {
		this.west = cell;
	}
	
}
