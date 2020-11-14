package dang.han.cs146.project3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MazeTest {

	
	
	@Test 
	/*
	 *  + +-+-+-+
	 *  |     | |
	 *  + +-+-+ +
	 *  | | |   |
	 *  + + +-+ +
	 *  |   |   |
	 *  +-+ + + +
	 *  |       |
	 *  +-+-+-+ +
	 */
	
	void test4x4BFS(){
		Maze maze4x4 = new Maze(4);
		//maze4x4.initializeMaze();			// maze gets initialized within constructor
		maze4x4.printMaze();
		
		maze4x4.removeWall(maze4x4.maze[0][0], maze4x4.maze[0][1]);
		maze4x4.removeWall(maze4x4.maze[0][1], maze4x4.maze[0][2]);
		maze4x4.removeWall(maze4x4.maze[1][0], maze4x4.maze[0][0]);
		maze4x4.removeWall(maze4x4.maze[1][0], maze4x4.maze[2][0]);
		maze4x4.removeWall(maze4x4.maze[2][0], maze4x4.maze[2][1]);
		maze4x4.removeWall(maze4x4.maze[1][1], maze4x4.maze[2][1]);
		maze4x4.removeWall(maze4x4.maze[3][1], maze4x4.maze[2][1]);
		maze4x4.removeWall(maze4x4.maze[3][1], maze4x4.maze[3][2]);
		maze4x4.removeWall(maze4x4.maze[3][2], maze4x4.maze[2][2]);
		maze4x4.removeWall(maze4x4.maze[2][3], maze4x4.maze[2][2]);
		maze4x4.removeWall(maze4x4.maze[2][3], maze4x4.maze[3][3]);
		
		maze4x4.printMaze();
		
		ArrayList<Node> expectedPath = new ArrayList<>();
		expectedPath.add(maze4x4.maze[0][0]);
		expectedPath.add(maze4x4.maze[1][0]);
		expectedPath.add(maze4x4.maze[2][0]);
		expectedPath.add(maze4x4.maze[2][1]);
		expectedPath.add(maze4x4.maze[3][1]);
		expectedPath.add(maze4x4.maze[3][2]);
		expectedPath.add(maze4x4.maze[2][2]);
		expectedPath.add(maze4x4.maze[2][3]);
		expectedPath.add(maze4x4.maze[3][3]);
		
		BFS bfs = new BFS();
		
		bfs.solveMaze(maze4x4.maze, maze4x4.maze[0][0], maze4x4.maze[3][3]);
		bfs.findShortestPath(maze4x4.maze, maze4x4.maze[0][0], maze4x4.maze[3][3]);
		System.out.println("\n");
		for (int i = 0; i < expectedPath.size(); i++) {
			assertEquals(expectedPath.get(i).getLocation(), bfs.path.get(i).getLocation());
		}
		
	//	maze4x4.printMaze();
		
	}

	
}
