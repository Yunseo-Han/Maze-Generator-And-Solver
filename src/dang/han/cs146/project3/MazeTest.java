package dang.han.cs146.project3;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MazeTest {
	
	BFS bfs;
	DFS dfs;
	
	//******************** testing
	Maze currentMaze;
	String[][] currentStrMaze;
	MazePrint output;
	
	@BeforeEach
	void setUp() throws IOException {
		bfs = new BFS();
		dfs = new DFS();
		
	}

	@Test 
	void maze4() throws IOException {
		output = new MazePrint("mazes/mazeoutput.txt");
		
		currentMaze = new Maze(4);
		currentMaze.createMaze();
		
		currentStrMaze = currentMaze.stringMaze();
		
		output.printString("----Random perfect maze with size 4----\n");
		output.printMaze(currentStrMaze);
		
		
		
		output.printString("\nBFS:");
		
		//Solves the maze using BFS.
		bfs.solveMaze(currentMaze.maze);
		bfs.findShortestPath(currentMaze.maze, currentMaze.maze[0][0], currentMaze.maze[currentMaze.size-1][currentMaze.size-1]);
		
		//Prints BFS steps
		String[][] withBFSSteps = currentMaze.mazeSteps(bfs.truePath, currentStrMaze);
		output.printMaze(withBFSSteps);
		
		//Print BFS solution
		String[][] bfsSolution = currentMaze.mazeHash(bfs.truePath, bfs.shortestPath, currentStrMaze);	
		output.printMaze(bfsSolution);
		
		
		output.printPath(bfs.shortestPath);
		
		
		
		
		output.printString("\nDFS:");
		
		dfs.solveMaze(currentMaze.maze);
		dfs.findShortestPath(currentMaze.maze, currentMaze.maze[0][0], currentMaze.maze[currentMaze.size-1][currentMaze.size-1]);
		
		String[][] withDFSSteps = currentMaze.mazeSteps(dfs.truePath, currentStrMaze);
		output.printMaze(withDFSSteps);
		
		String[][] dfsSolution = currentMaze.mazeHash(dfs.truePath, dfs.shortestPath, currentStrMaze);	
		output.printMaze(dfsSolution);
		
		
		output.printPath(dfs.shortestPath);
		
		
		output.closeFile();
		
		/*
		 * First, create and solve your own maze (see an example 
		 * of mine at the end) and store them as ASCII. It is easy to see in the ASCII
		 * if you have a perfect maze and if the solution is correct.
		 * Use the ASCII for the JUnit cases (is the printing equal to the one given in ASCII).
		 */
	}
	
	
	
	@Test
	void randomPerfectMaze4x4BFS() throws IOException {
		MazePrint fileprint = new MazePrint("mazes/maze4.txt");
		
		System.out.println("----Random perfect maze with size 4 (BFS)----");
		fileprint.printString("----Random perfect maze with size 4 (BFS)----\n");
		
		Maze testMaze = new Maze(4);
		testMaze.createMaze();
		
		//Prints the maze structure. 
		String[][] stringMaze = testMaze.stringMaze();
		
		testMaze.printMaze(stringMaze);
		fileprint.printMaze(stringMaze);

		
		//Solves the maze using BFS.
		System.out.println("BFS:");
		bfs.solveMaze(testMaze.maze);
		bfs.findShortestPath(testMaze.maze, testMaze.maze[0][0], testMaze.maze[testMaze.size-1][testMaze.size-1]);
		
		//Prints BFS steps
		String[][] withBFSSteps = testMaze.mazeSteps(bfs.truePath, stringMaze);
		testMaze.printMaze(withBFSSteps);
		fileprint.printMaze(withBFSSteps);
		
		//Print BFS solution
		String[][] bfsSolution = testMaze.mazeHash(bfs.truePath, bfs.shortestPath, stringMaze);	
		testMaze.printMaze(bfsSolution);
		fileprint.printMaze(bfsSolution);
		
		
		fileprint.printPath(bfs.shortestPath);
		fileprint.closeFile();
		
		
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
	void randomPerfectMaze4x4DFS() throws IOException {
		MazePrint fileprint = new MazePrint("mazes/maze4.txt");
		
		System.out.println("----Random perfect maze with size 4 (DFS)----");
		fileprint.printString("\n----Random perfect maze with size 4 (DFS)----\n");
		
		
		Maze testMaze = new Maze(4);
		testMaze.createMaze();
		
		//Prints the maze structure. 
		String[][] stringMaze = testMaze.stringMaze();
		testMaze.printMaze(stringMaze);
		fileprint.printMaze(stringMaze);
		
		//Solves the maze using DFS
		System.out.println("DFS:");
		dfs.solveMaze(testMaze.maze);
		String[][] withDFSSteps = testMaze.mazeSteps(dfs.truePath, stringMaze);
		testMaze.printMaze(withDFSSteps);
		fileprint.printMaze(withDFSSteps);
		
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
		fileprint.printMaze(dfsSolution);
		
		fileprint.printPath(dfs.shortestPath);
		fileprint.closeFile();
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
		Maze maze4x4 = new Maze(4);			
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
				
		bfs.solveMaze(maze4x4.maze);
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

	
}
