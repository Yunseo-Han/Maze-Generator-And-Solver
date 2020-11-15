package dang.han.cs146.project3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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
		String[][] stringMaze = testMaze.stringMaze();
		testMaze.printMaze(stringMaze);

		bfs.solveMaze(testMaze.maze, testMaze.maze[0][0], testMaze.maze[testMaze.size-1][testMaze.size-1]);
		bfs.findShortestPath(testMaze.maze, testMaze.maze[0][0], testMaze.maze[testMaze.size-1][testMaze.size-1]);
		System.out.println("\n");
		
	}
	
	@Test
	void findNeighborsTest() {
		Maze testMaze = new Maze(4);
		ArrayList<Node> neighbors = testMaze.findNeighbors(testMaze.maze[3][3]);
		//Expected order: north, south, west, east
		ArrayList<Node> expected = new ArrayList<>();
		expected.add(testMaze.maze[3][2]);
		expected.add(testMaze.maze[2][3]);
 		for (int i = 0; i < neighbors.size(); i++) {
 			assertEquals(expected.get(i), neighbors.get(i));
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
		maze4x4.removeWall(maze4x4.maze[0][3], maze4x4.maze[1][3]);
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
		
		System.out.println("\nBFS Test 4x4");
		String[][] stringMaze = maze4x4.stringMaze();
		maze4x4.printMaze(stringMaze);
		
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
			assertEquals(expectedPath.get(i).getLocation(), bfs.shortestPath.get(i).getLocation());
		}
		
		
		//***********************************************************************
		// another implementation of printing numbers
		String[][] withSteps = maze4x4.mazeSteps(bfs.truePath, stringMaze);
		maze4x4.printMaze(withSteps);
		
		String[][] withHash = maze4x4.mazeHash(bfs.shortestPath, stringMaze);
		maze4x4.printMaze(withHash);
		
		maze4x4.printMaze(stringMaze);				// ????? how does this have # and numbers??
		
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
	void test4x4DFS() {
		Maze maze4x4 = new Maze(4);
		
		maze4x4.removeWall(maze4x4.maze[0][0], maze4x4.maze[0][1]);
		maze4x4.removeWall(maze4x4.maze[0][1], maze4x4.maze[0][2]);
		maze4x4.removeWall(maze4x4.maze[0][3], maze4x4.maze[1][3]);
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
		
		System.out.println("\n\nDFS Test 4x4");
		String[][] stringMaze = maze4x4.stringMaze();
		maze4x4.printMaze(stringMaze);
		
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
		
		DFS dfs = new DFS();
		dfs.solveMaze(maze4x4.maze);
		dfs.findShortestPath(maze4x4.maze, maze4x4.maze[0][0], maze4x4.maze[maze4x4.size-1][maze4x4.size-1]);
		for (int i = 0; i < expectedPath.size(); i++) {
			assertEquals(expectedPath.get(i).getLocation(), dfs.shortestPath.get(i).getLocation());
		}
		
		
		System.out.println("\n");
		
		
		
		
		String[][] withSteps = maze4x4.mazeSteps(dfs.truePath, stringMaze);
		maze4x4.printMaze(withSteps);

		
		String[][] withHash = maze4x4.mazeHash(dfs.shortestPath, stringMaze);
		maze4x4.printMaze(withHash);
	}

	
}
