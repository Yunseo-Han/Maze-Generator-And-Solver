package dang.han.cs146.project3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

class BFSTest {

	@Test
	void bfsTest() {
		Random rand = new Random();
		rand.setSeed(20);
		int rand_index = rand.nextInt(7)+4; //range: 4-10
	}
	
	@Test 
	/*
	 *  + +-+-+-+
	 *  |     | |
	 *  + +-+-+ +
	 *  | | |   |
	 *  +-+ + + +
	 *  |     | |
	 *  +-+-+-+ +
	 */
	void test4x4(){
		Node [][] maze = new Node[4][4];
		
		//first row
		maze[0][0] = new Node(0,0);
		maze[0][1] = new Node(0,1);
		maze[0][2] = new Node(0,2);
		maze[0][3] = new Node(0,3);
		
		//second row
		maze[1][0] = new Node(1,0);
		maze[1][1] = new Node(1,1);
		maze[1][2] = new Node(1,2);
		maze[1][3] = new Node(1,3);
		
		//third row
		maze[2][0] = new Node(2,0);
		maze[2][1] = new Node(2,1);
		maze[2][2] = new Node(2,2);
		maze[2][3] = new Node(2,3);
		
		//fourth row
		maze[3][0] = new Node(2,0);
		maze[3][1] = new Node(2,1);
		maze[3][2] = new Node(2,2);
		maze[3][3] = new Node(2,3);
		
		
		
	}
	
}
