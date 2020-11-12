package dang.han.cs146.project3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MazeTest {

	
	
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
	
	void test4x4BFS(){
		Maze maze4x4 = new Maze(4);
		maze4x4.initializeMaze();
		
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
		
		BFS bfs = new BFS();
		bfs.search(maze4x4.maze, maze4x4.maze[0][0], maze4x4.maze[3][3]);
		bfs.printPath();
		maze4x4.printMaze();
		
	}


}
