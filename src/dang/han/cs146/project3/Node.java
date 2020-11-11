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
	private boolean hasNorthWall;
	private boolean hasSouthWall;
	private boolean hasEastWall;
	private boolean hasWestWall;
	ArrayList<Node> adjList;			// Holds the adjList that have an edge to this Node
	ArrayList<Node> neighbors;			// Neighbors of Node. NOTE: isn't necessarily have an edge/connection to this Node

	
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
		this.hasNorthWall = false;
		this.hasSouthWall = false;
		this.hasEastWall = false;
		this.hasWestWall = false;
		adjList = new ArrayList<>();
		neighbors = new ArrayList<>();
		discoverStatus = Status.UNDISCOVERED;
		predecessor = null;
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
	
	
	public boolean isConntectedTo(Node that) {
		// find position of that in relation to this Node
		
			// check if Node that is north of this.Node
			if ( (that.row == this.row - 1) && hasNorthWall == false ) {
				return true;
			}			
		
			// check if Node that is south of this.Node 
			else if ( (that.row == this.row + 1) && hasSouthWall == false ) {
				return true;
			}
		
			// check if Node that is east of this.Node
			else if ( (that.col == this.col + 1) && hasEastWall == false ) {
				return true;
			}
		
			// check if Node that is west of this.Node
			else if ( (that.col == this.col - 1) && hasWestWall == false ) {
				return true;
			}
		
		return false;
	}
	
}
