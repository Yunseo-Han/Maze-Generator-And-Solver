package dang.han.cs146.project3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MazeTest {
	
	BFS bfs;
	DFS dfs;
	@BeforeEach
	void setUp() {
		bfs = new BFS();
		dfs = new DFS();
	}

	
	@Test
	void randomPerfectMaze4x4BFS() {
		System.out.println("----Random perfect maze with size 4 (BFS)----");
		Maze testMaze = new Maze();
		testMaze.createMaze();
		
		//Prints the maze structure. 
		String[][] stringMaze = testMaze.stringMaze();
		testMaze.printMaze(stringMaze);

		
		//Solves the maze using BFS.
		System.out.println("BFS:");
		bfs.solveMaze(testMaze.maze, testMaze.maze[0][0], testMaze.maze[testMaze.size-1][testMaze.size-1]);
		bfs.findShortestPath(testMaze.maze, testMaze.maze[0][0], testMaze.maze[testMaze.size-1][testMaze.size-1]);
		
		//Prints BFS steps
		String[][] withBFSSteps = testMaze.mazeSteps(bfs.truePath, stringMaze);
		testMaze.printMaze(withBFSSteps);
		
		//Print BFS solution
		String[][] bfsSolution = testMaze.mazeHash(bfs.truePath, bfs.shortestPath, stringMaze);	
		testMaze.printMaze(bfsSolution);
		
		
		ArrayList<Node> expectedPath = new ArrayList<>();
		expectedPath.add(testMaze.maze[0][0]);
		expectedPath.add(testMaze.maze[1][0]);
		expectedPath.add(testMaze.maze[1][1]);
		expectedPath.add(testMaze.maze[1][2]);
		expectedPath.add(testMaze.maze[1][3]);
		expectedPath.add(testMaze.maze[2][3]);
		expectedPath.add(testMaze.maze[3][3]);
		
		//testing BFS
		for (int i = 0; i < expectedPath.size(); i++) {
			assertEquals(expectedPath.get(i).getLocation(), bfs.shortestPath.get(i).getLocation());
		}
		
	}
	
	@Test
	void randomPerfectMaze4x4DFS() {
		System.out.println("----Random perfect maze with size 4 (DFS)----");
		Maze testMaze = new Maze();
		testMaze.createMaze();
		
		//Prints the maze structure. 
		String[][] stringMaze = testMaze.stringMaze();
		testMaze.printMaze(stringMaze);
		
		//Solves the maze using DFS
		System.out.println("DFS:");
		dfs.solveMaze(testMaze.maze);
		String[][] withDFSSteps = testMaze.mazeSteps(dfs.truePath, stringMaze);
		testMaze.printMaze(withDFSSteps);
		
		ArrayList<Node> expectedPath = new ArrayList<>();
		expectedPath.add(testMaze.maze[0][0]);
		expectedPath.add(testMaze.maze[1][0]);
		expectedPath.add(testMaze.maze[1][1]);
		expectedPath.add(testMaze.maze[1][2]);
		expectedPath.add(testMaze.maze[1][3]);
		expectedPath.add(testMaze.maze[2][3]);
		expectedPath.add(testMaze.maze[3][3]);	
						
		//testing DFS
		for (int i = 0; i < expectedPath.size(); i++) {
			assertEquals(expectedPath.get(i).getLocation(), dfs.shortestPath.get(i).getLocation());
		}
						
		//Print DFS solution
		String[][] dfsSolution = testMaze.mazeHash(dfs.truePath, dfs.shortestPath, stringMaze);
		testMaze.printMaze(dfsSolution);
	}
	
	
	/*
	@Test
	void randomPerfectMaze4x4() {
		System.out.println("----Random perfect maze with size 4 (BFS)----");
		Maze testMaze = new Maze();
		testMaze.createMaze();
		
		//Prints the maze structure. 
		String[][] stringMaze = testMaze.stringMaze();
		testMaze.printMaze(stringMaze);

		
		//Solves the maze using BFS.
		System.out.println("BFS:");
		bfs.solveMaze(testMaze.maze, testMaze.maze[0][0], testMaze.maze[testMaze.size-1][testMaze.size-1]);
		bfs.findShortestPath(testMaze.maze, testMaze.maze[0][0], testMaze.maze[testMaze.size-1][testMaze.size-1]);
		
		//Prints BFS steps
		String[][] withBFSSteps = testMaze.mazeSteps(bfs.truePath, stringMaze);
		testMaze.printMaze(withBFSSteps);
		
		//Print BFS solution
		String[][] bfsSolution = testMaze.mazeHash(bfs.truePath, bfs.shortestPath, stringMaze);	
		testMaze.printMaze(bfsSolution);
		
		
		ArrayList<Node> expectedPath = new ArrayList<>();
		expectedPath.add(testMaze.maze[0][0]);
		expectedPath.add(testMaze.maze[1][0]);
		expectedPath.add(testMaze.maze[1][1]);
		expectedPath.add(testMaze.maze[1][2]);
		expectedPath.add(testMaze.maze[1][3]);
		expectedPath.add(testMaze.maze[2][3]);
		expectedPath.add(testMaze.maze[3][3]);
		
		//testing BFS
		for (int i = 0; i < expectedPath.size(); i++) {
			assertEquals(expectedPath.get(i).getLocation(), bfs.shortestPath.get(i).getLocation());
		}
		
		//Solves the maze using DFS
		System.out.println("DFS:");
		dfs.solveMaze(testMaze.maze);
		String[][] withDFSSteps = testMaze.mazeSteps(dfs.truePath, stringMaze);
		testMaze.printMaze(withDFSSteps);
		
		//Print DFS solution
		String[][] dfsSolution = testMaze.mazeHash(dfs.truePath, dfs.shortestPath, stringMaze);
		testMaze.printMaze(dfsSolution);
	}
	*/
	
	
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
	
	void test4x4BFS() {
		Maze maze4x4 = new Maze();			
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
		
		System.out.println("-------------------BFS Test 4x4-------------------");
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
				
		bfs.solveMaze(maze4x4.maze, maze4x4.maze[0][0], maze4x4.maze[maze4x4.size-1][maze4x4.size-1]);
		bfs.findShortestPath(maze4x4.maze, maze4x4.maze[0][0], maze4x4.maze[maze4x4.size-1][maze4x4.size-1]);
		
		for (int i = 0; i < expectedPath.size(); i++) {
			assertEquals(expectedPath.get(i).getLocation(), bfs.shortestPath.get(i).getLocation());
		}
		
		//***********************************************************************
		// another implementation of printing numbers
		String[][] withSteps = maze4x4.mazeSteps(bfs.truePath, stringMaze);
		maze4x4.printMaze(withSteps);
		
		String[][] withHash = maze4x4.mazeHash(bfs.truePath, bfs.shortestPath, stringMaze);
		maze4x4.printMaze(withHash);
				
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
	void test4x4DFS(){
		Maze maze4x4 = new Maze();
		
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
		
		System.out.println("-------------------DFS Test 4x4-------------------");
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
		
		for (int i = 0; i < expectedPath.size(); i++) {
			assertEquals(expectedPath.get(i).getLocation(), dfs.shortestPath.get(i).getLocation());
		}
		
		String[][] withSteps = maze4x4.mazeSteps(dfs.truePath, stringMaze);
		maze4x4.printMaze(withSteps);

		
		String[][] withHash = maze4x4.mazeHash(dfs.truePath, dfs.shortestPath, stringMaze);
		maze4x4.printMaze(withHash);
	}
	
	@Test
	void findNeighborsTest() {
		Maze testMaze = new Maze();
		ArrayList<Node> neighbors = testMaze.findNeighbors(testMaze.maze[3][3]);
		//Expected order: north, south, west, east
		ArrayList<Node> expected = new ArrayList<>();
		expected.add(testMaze.maze[3][2]);
		expected.add(testMaze.maze[2][3]);
 		for (int i = 0; i < neighbors.size(); i++) {
 			assertEquals(expected.get(i), neighbors.get(i));
		}
	}

	
}
