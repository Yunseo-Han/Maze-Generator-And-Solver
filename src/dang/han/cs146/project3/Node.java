package dang.han.cs146.project3;


import java.util.ArrayList;


/**
 * A node class meant to represent each cell in the maze. Empty walls represented by connections in north, south, east, or west. 
 * @author yunseo
 *
 */
public class Node {
	
	enum Status {	UNDISCOVERED, VISITED, EXPLORED;	}
	
	int row;	//Node's row position
	int col;	//Node's col position
	boolean hasNorthWall;	// stores true if Node has a north wall, else false
	boolean hasSouthWall;	// stores true if Node has a south wall, else false
	boolean hasEastWall;	// stores true if Node has a east wall, else false
	boolean hasWestWall;	// stores true if Node has a west wall, else false
	Status discoverStatus;
	
	ArrayList<Node> adjList;	// Holds the adjList that have an edge to this Node
	
	Node predecessor; 	// Node that comes before this Node
	int step;	//Node's step respective to Maze solution
	
	
	public Node(int row, int col) {
		this.row = row;
		this.col = col;
		this.hasNorthWall = true;
		this.hasSouthWall = true;
		this.hasEastWall = true;
		this.hasWestWall = true;
		this.discoverStatus = Status.UNDISCOVERED;
		
		this.adjList = new ArrayList<>();
		
		this.predecessor = null;
		this.step = -1;
	}
	
	
	/*
	 * Removes this Node's wall to Node that and connects the Nodes.
	 */
	
	public void removeWallBtwn(Node that) {
		// Node that is north of this Node
		if (that.row == this.row - 1) {
			hasNorthWall = false;
			connectNorth(that);
		}
		
		// Node that is south of this Node
		else if (that.row == this.row + 1) {
			hasSouthWall = false;
			connectSouth(that);
		}
		
		// Node that is east of this Node
		else if (that.col == this.col + 1) {
			hasEastWall = false;
			connectEast(that);
		}

		// Node that is west of this Node
		else if (that.col == this.col - 1) {
			hasEastWall = false;
			connectWest(that);
		}
	}
	
	
	
	/**
	 * @return true if if this Node has north, south, east, and west walls intact
	 */
	public boolean allWallsIntact() {
		if (this.hasNorthWall==true && this.hasSouthWall==true && this.hasEastWall==true && this.hasWestWall==true) {
			return true;
		}
		return false;
	}
	
	
	
	public void connectNorth(Node cell) {
		hasNorthWall = false;
		adjList.add(cell); 
	}
	
	public void connectSouth(Node cell) {
		this.hasSouthWall = false;
		adjList.add(cell);
	}	
	
	public void connectEast(Node cell) {
		this.hasEastWall = false;
		adjList.add(cell);
	}
	
	public void connectWest(Node cell) {
		this.hasWestWall = false;
		adjList.add(cell);
	}
	
	
	// getters and setters *************************************************************
	
	public String getLocation() {
		return "(" + row + ", " + col + ")";
	}
	
	
	public void setStatus(Status discoverStatus) {
		this.discoverStatus = discoverStatus;
	}
	
	
	public void setStep(int step) {
		this.step = step;
	}
	
	public void setPredecessor(Node cell) {
		predecessor = cell;
	}
	
	
	
}
