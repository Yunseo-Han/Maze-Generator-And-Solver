package dang.han.cs146.project3;

/**
 * A node class meant to represent each cell in the maze. Empty walls represented by connections in north, south, east, or west. 
 * @author yunseo
 *
 */
public class Node {
	private int row;
	private int col;
	private Node north;
	private Node south;
	private Node east;
	private Node west;
	
	
	public Node(int row, int col) {
		this.row = row;
		this.col = col;
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
