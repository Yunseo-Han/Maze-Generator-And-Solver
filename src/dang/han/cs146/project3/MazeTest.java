package dang.han.cs146.project3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MazeTest {
	
	BFS bfs;
	@BeforeEach
	void setUp() {
	bfs = new BFS();
	}

	@Test
	void randomPerfectMaze4x4() {
		System.out.println("Random perfect maze with size 4");
		Maze testMaze = new Maze(4);
		testMaze.createMaze();
		testMaze.printMaze();

		bfs.solveMaze(testMaze.maze, testMaze.maze[0][0], testMaze.maze[testMaze.size-1][testMaze.size-1]);
		bfs.findShortestPath(testMaze.maze, testMaze.maze[0][0], testMaze.maze[testMaze.size-1][testMaze.size-1]);
		System.out.println("\n");
		
	}
	
	@Test
	void randomPerfectMaze8x8() {
		System.out.println("Random perfect maze with size 8");
		Maze testMaze = new Maze(8);
		testMaze.createMaze();
		testMaze.printMaze();
	}
	
	@Test
	void findNeighborsTest() {
		Maze testMaze = new Maze(4);
		ArrayList<Node> neighbors = testMaze.findNeighbors(testMaze.maze[3][3]);
		for (int i = 0; i < neighbors.size(); i++) {
			System.out.println(neighbors.get(i).getLocation());
		}
	}
	
	@Test 
	/*
	 *  + +-+-+-+
	 *  |     | |
	 *  + +-+-+ +
	 *  | | |   |
	 *  + + +-+ +
	 *  |   |   |
	 *  +-+ + + +
	 *  |     | |
	 *  +-+-+-+ +
	 */
	
	void test4x4BFS(){
		Maze maze4x4 = new Maze(4);
		//maze4x4.initializeMaze();			// maze gets initialized within constructor
			
		maze4x4.removeWall(maze4x4.maze[0][0], maze4x4.maze[0][1]);
		maze4x4.removeWall(maze4x4.maze[0][1], maze4x4.maze[0][2]);
		maze4x4.removeWall(maze4x4.maze[1][0], maze4x4.maze[0][0]);
		maze4x4.removeWall(maze4x4.maze[1][0], maze4x4.maze[2][0]);
		maze4x4.removeWall(maze4x4.maze[2][0], maze4x4.maze[2][1]);
		maze4x4.removeWall(maze4x4.maze[1][1], maze4x4.maze[2][1]);
		maze4x4.removeWall(maze4x4.maze[1][2], maze4x4.maze[1][3]);
		maze4x4.removeWall(maze4x4.maze[1][3], maze4x4.maze[2][3]);
		maze4x4.removeWall(maze4x4.maze[3][1], maze4x4.maze[2][1]);
		maze4x4.removeWall(maze4x4.maze[3][0], maze4x4.maze[3][1]);
		maze4x4.removeWall(maze4x4.maze[3][1], maze4x4.maze[3][2]);
		maze4x4.removeWall(maze4x4.maze[3][2], maze4x4.maze[2][2]);
		maze4x4.removeWall(maze4x4.maze[2][3], maze4x4.maze[2][2]);
		maze4x4.removeWall(maze4x4.maze[2][3], maze4x4.maze[3][3]);
		
		System.out.println("BFS Test 4x4");
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
		
		bfs.solveMaze(maze4x4.maze, maze4x4.maze[0][0], maze4x4.maze[maze4x4.size-1][maze4x4.size-1]);
		bfs.findShortestPath(maze4x4.maze, maze4x4.maze[0][0], maze4x4.maze[maze4x4.size-1][maze4x4.size-1]);
		System.out.println("\n");
		
		for (int i = 0; i < expectedPath.size(); i++) {
			assertEquals(expectedPath.get(i).getLocation(), bfs.path.get(i).getLocation());
		}
		
		
		
	}
	
	@Test
	void findNeighborsDFS() {
		Maze maze4x4 = new Maze(4);
		
		DFS dfs = new DFS();
		dfs.solveMaze(maze4x4.maze);
		for (Node e: dfs.path) {
			System.out.println(e.row + " " + e.col);
		}
		dfs.shortestPath(dfs.path);
	}

	
}
