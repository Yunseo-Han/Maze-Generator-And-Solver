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
	
	/* 
	 * The next 7 test cases are our own personal generated mazes
	 */
	@Test 
	void maze4() throws IOException {
		output = new MazePrint("mazes/maze4.txt");
		int mazeSize = 4;
		currentMaze = new Maze(mazeSize);
		
		//Recording time to create Maze
		long elapsedTime = 0;
		long start = System.nanoTime();
		currentMaze.createMaze();
		long end = System.nanoTime();
		elapsedTime = (end - start);	
		
		currentStrMaze = currentMaze.stringMaze();
		
		output.printString("----Random perfect maze with size " + mazeSize + "----\n");
		output.printMaze(currentStrMaze);
		output.printString("Elapsed time generating maze of size " + mazeSize + ": " + elapsedTime + " ns\n");
		output.printString("\nBFS:");
		
		//Solves the maze using BFS + get elapsed time
		elapsedTime = 0;
		start = System.nanoTime();
		bfs.solveMaze(currentMaze.maze);
		bfs.findShortestPath(currentMaze.maze, currentMaze.maze[0][0], currentMaze.maze[currentMaze.size-1][currentMaze.size-1]);
		end = System.nanoTime();
		elapsedTime = (end - start);
	
		//Prints BFS steps
		currentMaze.mazeSteps(bfs.truePath, currentStrMaze);
		output.printMaze(currentMaze.mazeSteps);
		
		//Print BFS solution
		String[][] bfsSolution = currentMaze.mazeHash(bfs.truePath, bfs.shortestPath, currentStrMaze);	
		output.printMaze(bfsSolution);
		
		//BFS information
		output.printPath(bfs.shortestPath);
		output.printString("Elapsed time using BFS to solve maze of size " + mazeSize + ": " + elapsedTime + " ns\n\n");
		output.printString("Length of path: " + bfs.shortestPath.size() + "\n\n");
		output.printString("Visited cells: " + bfs.truePath.size() + "\n\n");

		
		output.printString("\nDFS:");
		currentMaze.resetMaze();
		
		//Solves the maze using DFS + get elapsed time
		elapsedTime = 0;
		start = System.nanoTime();
		dfs.solveMaze(currentMaze.maze);
		dfs.findShortestPath(currentMaze.maze, currentMaze.maze[0][0], currentMaze.maze[currentMaze.size-1][currentMaze.size-1]);
		end = System.nanoTime();
		elapsedTime = (end - start);
		
		//Prints DFS steps
		currentMaze.mazeSteps(dfs.truePath, currentStrMaze);
		output.printMaze(currentMaze.mazeSteps);

		
		//Print DFS solution
		String[][] dfsSolution = currentMaze.mazeHash(dfs.truePath, dfs.shortestPath, currentStrMaze);	
		output.printMaze(dfsSolution);
		
		//DFS information
		output.printPath(dfs.shortestPath);
		output.printString("Elapsed time using DFS to solve maze of size " + mazeSize + ": " + elapsedTime + " ns\n\n");
		output.printString("Length of path: " + dfs.shortestPath.size() + "\n\n");
		output.printString("Visited cells: " + dfs.truePath.size()+ "\n\n");
		
		assertEquals(bfs.getPath(), dfs.getPath());
		
		output.closeFile();
		
		
	}

	@Test 
	void maze5() throws IOException {
		output = new MazePrint("mazes/maze5.txt");
		int mazeSize = 5;
		currentMaze = new Maze(mazeSize);
		
		//Recording time to create Maze
		long elapsedTime = 0;
		long start = System.nanoTime();
		currentMaze.createMaze();
		long end = System.nanoTime();
		elapsedTime = (end - start);	
		
		currentStrMaze = currentMaze.stringMaze();
		
		output.printString("----Random perfect maze with size " + mazeSize + "----\n");
		output.printMaze(currentStrMaze);
		output.printString("Elapsed time generating maze of size " + mazeSize + ": " + elapsedTime + " ns\n");
		output.printString("\nBFS:");
		
		//Solves the maze using BFS + get elapsed time
		elapsedTime = 0;
		start = System.nanoTime();
		bfs.solveMaze(currentMaze.maze);
		bfs.findShortestPath(currentMaze.maze, currentMaze.maze[0][0], currentMaze.maze[currentMaze.size-1][currentMaze.size-1]);
		end = System.nanoTime();
		elapsedTime = (end - start);
	
		//Prints BFS steps
		currentMaze.mazeSteps(bfs.truePath, currentStrMaze);
		output.printMaze(currentMaze.mazeSteps);
		
		//Print BFS solution
		String[][] bfsSolution = currentMaze.mazeHash(bfs.truePath, bfs.shortestPath, currentStrMaze);	
		output.printMaze(bfsSolution);
		
		//BFS information
		output.printPath(bfs.shortestPath);
		output.printString("Elapsed time using BFS to solve maze of size " + mazeSize + ": " + elapsedTime + " ns\n\n");
		output.printString("Length of path: " + bfs.shortestPath.size() + "\n\n");
		output.printString("Visited cells: " + bfs.truePath.size() + "\n\n");

		
		output.printString("\nDFS:");
		currentMaze.resetMaze();
		
		//Solves the maze using DFS + get elapsed time
		elapsedTime = 0;
		start = System.nanoTime();
		dfs.solveMaze(currentMaze.maze);
		dfs.findShortestPath(currentMaze.maze, currentMaze.maze[0][0], currentMaze.maze[currentMaze.size-1][currentMaze.size-1]);
		end = System.nanoTime();
		elapsedTime = (end - start);
		
		//Prints DFS steps
		currentMaze.mazeSteps(dfs.truePath, currentStrMaze);
		output.printMaze(currentMaze.mazeSteps);

		
		//Print DFS solution
		String[][] dfsSolution = currentMaze.mazeHash(dfs.truePath, dfs.shortestPath, currentStrMaze);	
		output.printMaze(dfsSolution);
		
		//DFS information
		output.printPath(dfs.shortestPath);
		output.printString("Elapsed time using DFS to solve maze of size " + mazeSize + ": " + elapsedTime + " ns\n\n");
		output.printString("Length of path: " + dfs.shortestPath.size() + "\n\n");
		output.printString("Visited cells: " + dfs.truePath.size()+ "\n\n");
		
		assertEquals(bfs.getPath(), dfs.getPath());
		
		output.closeFile();
		
	}

	@Test 
	void maze6() throws IOException {
		output = new MazePrint("mazes/maze6.txt");
		int mazeSize = 6;
		currentMaze = new Maze(mazeSize);
		
		//Recording time to create Maze
		long elapsedTime = 0;
		long start = System.nanoTime();
		currentMaze.createMaze();
		long end = System.nanoTime();
		elapsedTime = (end - start);	
		
		currentStrMaze = currentMaze.stringMaze();
		
		output.printString("----Random perfect maze with size " + mazeSize + "----\n");
		output.printMaze(currentStrMaze);
		output.printString("Elapsed time generating maze of size " + mazeSize + ": " + elapsedTime + " ns\n");
		output.printString("\nBFS:");
		
		//Solves the maze using BFS + get elapsed time
		elapsedTime = 0;
		start = System.nanoTime();
		bfs.solveMaze(currentMaze.maze);
		bfs.findShortestPath(currentMaze.maze, currentMaze.maze[0][0], currentMaze.maze[currentMaze.size-1][currentMaze.size-1]);
		end = System.nanoTime();
		elapsedTime = (end - start);
	
		//Prints BFS steps
		currentMaze.mazeSteps(bfs.truePath, currentStrMaze);
		output.printMaze(currentMaze.mazeSteps);
		
		//Print BFS solution
		String[][] bfsSolution = currentMaze.mazeHash(bfs.truePath, bfs.shortestPath, currentStrMaze);	
		output.printMaze(bfsSolution);
		
		//BFS information
		output.printPath(bfs.shortestPath);
		output.printString("Elapsed time using BFS to solve maze of size " + mazeSize + ": " + elapsedTime + " ns\n\n");
		output.printString("Length of path: " + bfs.shortestPath.size() + "\n\n");
		output.printString("Visited cells: " + bfs.truePath.size() + "\n\n");

		
		output.printString("\nDFS:");
		currentMaze.resetMaze();
		
		//Solves the maze using DFS + get elapsed time
		elapsedTime = 0;
		start = System.nanoTime();
		dfs.solveMaze(currentMaze.maze);
		dfs.findShortestPath(currentMaze.maze, currentMaze.maze[0][0], currentMaze.maze[currentMaze.size-1][currentMaze.size-1]);
		end = System.nanoTime();
		elapsedTime = (end - start);
		
		//Prints DFS steps
		currentMaze.mazeSteps(dfs.truePath, currentStrMaze);
		output.printMaze(currentMaze.mazeSteps);

		
		//Print DFS solution
		String[][] dfsSolution = currentMaze.mazeHash(dfs.truePath, dfs.shortestPath, currentStrMaze);	
		output.printMaze(dfsSolution);
		
		//DFS information
		output.printPath(dfs.shortestPath);
		output.printString("Elapsed time using DFS to solve maze of size " + mazeSize + ": " + elapsedTime + " ns\n\n");
		output.printString("Length of path: " + dfs.shortestPath.size() + "\n\n");
		output.printString("Visited cells: " + dfs.truePath.size()+ "\n\n");
		
		assertEquals(bfs.getPath(), dfs.getPath());
		
		output.closeFile();
		
	}
	
	@Test 
	void maze7() throws IOException {
		output = new MazePrint("mazes/maze7.txt");
		int mazeSize = 7;
		currentMaze = new Maze(mazeSize);
		
		//Recording time to create Maze
		long elapsedTime = 0;
		long start = System.nanoTime();
		currentMaze.createMaze();
		long end = System.nanoTime();
		elapsedTime = (end - start);	
		
		currentStrMaze = currentMaze.stringMaze();
		
		output.printString("----Random perfect maze with size " + mazeSize + "----\n");
		output.printMaze(currentStrMaze);
		output.printString("Elapsed time generating maze of size " + mazeSize + ": " + elapsedTime + " ns\n");
		output.printString("\nBFS:");
		
		//Solves the maze using BFS + get elapsed time
		elapsedTime = 0;
		start = System.nanoTime();
		bfs.solveMaze(currentMaze.maze);
		bfs.findShortestPath(currentMaze.maze, currentMaze.maze[0][0], currentMaze.maze[currentMaze.size-1][currentMaze.size-1]);
		end = System.nanoTime();
		elapsedTime = (end - start);
	
		//Prints BFS steps
		currentMaze.mazeSteps(bfs.truePath, currentStrMaze);
		output.printMaze(currentMaze.mazeSteps);
		
		//Print BFS solution
		String[][] bfsSolution = currentMaze.mazeHash(bfs.truePath, bfs.shortestPath, currentStrMaze);	
		output.printMaze(bfsSolution);
		
		//BFS information
		output.printPath(bfs.shortestPath);
		output.printString("Elapsed time using BFS to solve maze of size " + mazeSize + ": " + elapsedTime + " ns\n\n");
		output.printString("Length of path: " + bfs.shortestPath.size() + "\n\n");
		output.printString("Visited cells: " + bfs.truePath.size() + "\n\n");

		
		output.printString("\nDFS:");
		currentMaze.resetMaze();
		
		//Solves the maze using DFS + get elapsed time
		elapsedTime = 0;
		start = System.nanoTime();
		dfs.solveMaze(currentMaze.maze);
		dfs.findShortestPath(currentMaze.maze, currentMaze.maze[0][0], currentMaze.maze[currentMaze.size-1][currentMaze.size-1]);
		end = System.nanoTime();
		elapsedTime = (end - start);
		
		//Prints DFS steps
		currentMaze.mazeSteps(dfs.truePath, currentStrMaze);
		output.printMaze(currentMaze.mazeSteps);

		
		//Print DFS solution
		String[][] dfsSolution = currentMaze.mazeHash(dfs.truePath, dfs.shortestPath, currentStrMaze);	
		output.printMaze(dfsSolution);
		
		//DFS information
		output.printPath(dfs.shortestPath);
		output.printString("Elapsed time using DFS to solve maze of size " + mazeSize + ": " + elapsedTime + " ns\n\n");
		output.printString("Length of path: " + dfs.shortestPath.size() + "\n\n");
		output.printString("Visited cells: " + dfs.truePath.size()+ "\n\n");
		
		assertEquals(bfs.getPath(), dfs.getPath());
		
		output.closeFile();
		
	}
	
	@Test 
	void maze8() throws IOException {
		output = new MazePrint("mazes/maze8.txt");
		int mazeSize = 8;
		currentMaze = new Maze(mazeSize);
		
		//Recording time to create Maze
		long elapsedTime = 0;
		long start = System.nanoTime();
		currentMaze.createMaze();
		long end = System.nanoTime();
		elapsedTime = (end - start);	
		
		currentStrMaze = currentMaze.stringMaze();
		
		output.printString("----Random perfect maze with size " + mazeSize + "----\n");
		output.printMaze(currentStrMaze);
		output.printString("Elapsed time generating maze of size " + mazeSize + ": " + elapsedTime + " ns\n");
		output.printString("\nBFS:");
		
		//Solves the maze using BFS + get elapsed time
		elapsedTime = 0;
		start = System.nanoTime();
		bfs.solveMaze(currentMaze.maze);
		bfs.findShortestPath(currentMaze.maze, currentMaze.maze[0][0], currentMaze.maze[currentMaze.size-1][currentMaze.size-1]);
		end = System.nanoTime();
		elapsedTime = (end - start);
	
		//Prints BFS steps
		currentMaze.mazeSteps(bfs.truePath, currentStrMaze);
		output.printMaze(currentMaze.mazeSteps);
		
		//Print BFS solution
		String[][] bfsSolution = currentMaze.mazeHash(bfs.truePath, bfs.shortestPath, currentStrMaze);	
		output.printMaze(bfsSolution);
		
		//BFS information
		output.printPath(bfs.shortestPath);
		output.printString("Elapsed time using BFS to solve maze of size " + mazeSize + ": " + elapsedTime + " ns\n\n");
		output.printString("Length of path: " + bfs.shortestPath.size() + "\n\n");
		output.printString("Visited cells: " + bfs.truePath.size() + "\n\n");

		
		output.printString("\nDFS:");
		currentMaze.resetMaze();
		
		//Solves the maze using DFS + get elapsed time
		elapsedTime = 0;
		start = System.nanoTime();
		dfs.solveMaze(currentMaze.maze);
		dfs.findShortestPath(currentMaze.maze, currentMaze.maze[0][0], currentMaze.maze[currentMaze.size-1][currentMaze.size-1]);
		end = System.nanoTime();
		elapsedTime = (end - start);
		
		//Prints DFS steps
		currentMaze.mazeSteps(dfs.truePath, currentStrMaze);
		output.printMaze(currentMaze.mazeSteps);

		
		//Print DFS solution
		String[][] dfsSolution = currentMaze.mazeHash(dfs.truePath, dfs.shortestPath, currentStrMaze);	
		output.printMaze(dfsSolution);
		
		//DFS information
		output.printPath(dfs.shortestPath);
		output.printString("Elapsed time using DFS to solve maze of size " + mazeSize + ": " + elapsedTime + " ns\n\n");
		output.printString("Length of path: " + dfs.shortestPath.size() + "\n\n");
		output.printString("Visited cells: " + dfs.truePath.size()+ "\n\n");
		
		assertEquals(bfs.getPath(), dfs.getPath());
		
		output.closeFile();
		
	}
	
	@Test 
	void maze9() throws IOException {
		output = new MazePrint("mazes/maze9.txt");
		int mazeSize = 9;
		currentMaze = new Maze(mazeSize);
		
		//Recording time to create Maze
		long elapsedTime = 0;
		long start = System.nanoTime();
		currentMaze.createMaze();
		long end = System.nanoTime();
		elapsedTime = (end - start);	
		
		currentStrMaze = currentMaze.stringMaze();
		
		output.printString("----Random perfect maze with size " + mazeSize + "----\n");
		output.printMaze(currentStrMaze);
		output.printString("Elapsed time generating maze of size " + mazeSize + ": " + elapsedTime + " ns\n");
		output.printString("\nBFS:");
		
		//Solves the maze using BFS + get elapsed time
		elapsedTime = 0;
		start = System.nanoTime();
		bfs.solveMaze(currentMaze.maze);
		bfs.findShortestPath(currentMaze.maze, currentMaze.maze[0][0], currentMaze.maze[currentMaze.size-1][currentMaze.size-1]);
		end = System.nanoTime();
		elapsedTime = (end - start);
	
		//Prints BFS steps
		currentMaze.mazeSteps(bfs.truePath, currentStrMaze);
		output.printMaze(currentMaze.mazeSteps);
		
		//Print BFS solution
		String[][] bfsSolution = currentMaze.mazeHash(bfs.truePath, bfs.shortestPath, currentStrMaze);	
		output.printMaze(bfsSolution);
		
		//BFS information
		output.printPath(bfs.shortestPath);
		output.printString("Elapsed time using BFS to solve maze of size " + mazeSize + ": " + elapsedTime + " ns\n\n");
		output.printString("Length of path: " + bfs.shortestPath.size() + "\n\n");
		output.printString("Visited cells: " + bfs.truePath.size() + "\n\n");

		
		output.printString("\nDFS:");
		currentMaze.resetMaze();
		
		//Solves the maze using DFS + get elapsed time
		elapsedTime = 0;
		start = System.nanoTime();
		dfs.solveMaze(currentMaze.maze);
		dfs.findShortestPath(currentMaze.maze, currentMaze.maze[0][0], currentMaze.maze[currentMaze.size-1][currentMaze.size-1]);
		end = System.nanoTime();
		elapsedTime = (end - start);
		
		//Prints DFS steps
		currentMaze.mazeSteps(dfs.truePath, currentStrMaze);
		output.printMaze(currentMaze.mazeSteps);

		
		//Print DFS solution
		String[][] dfsSolution = currentMaze.mazeHash(dfs.truePath, dfs.shortestPath, currentStrMaze);	
		output.printMaze(dfsSolution);
		
		//DFS information
		output.printPath(dfs.shortestPath);
		output.printString("Elapsed time using DFS to solve maze of size " + mazeSize + ": " + elapsedTime + " ns\n\n");
		output.printString("Length of path: " + dfs.shortestPath.size() + "\n\n");
		output.printString("Visited cells: " + dfs.truePath.size()+ "\n\n");
		
		assertEquals(bfs.getPath(), dfs.getPath());
		
		output.closeFile();
		
	}
	
	@Test 
	void maze10() throws IOException {
		output = new MazePrint("mazes/maze10.txt");
		int mazeSize = 10;
		currentMaze = new Maze(mazeSize);
		
		//Recording time to create Maze
		long elapsedTime = 0;
		long start = System.nanoTime();
		currentMaze.createMaze();
		long end = System.nanoTime();
		elapsedTime = (end - start);	
		
		currentStrMaze = currentMaze.stringMaze();
		
		output.printString("----Random perfect maze with size " + mazeSize + "----\n");
		output.printMaze(currentStrMaze);
		output.printString("Elapsed time generating maze of size " + mazeSize + ": " + elapsedTime + " ns\n");
		output.printString("\nBFS:");
		
		//Solves the maze using BFS + get elapsed time
		elapsedTime = 0;
		start = System.nanoTime();
		bfs.solveMaze(currentMaze.maze);
		bfs.findShortestPath(currentMaze.maze, currentMaze.maze[0][0], currentMaze.maze[currentMaze.size-1][currentMaze.size-1]);
		end = System.nanoTime();
		elapsedTime = (end - start);
	
		//Prints BFS steps
		currentMaze.mazeSteps(bfs.truePath, currentStrMaze);
		output.printMaze(currentMaze.mazeSteps);
		
		//Print BFS solution
		String[][] bfsSolution = currentMaze.mazeHash(bfs.truePath, bfs.shortestPath, currentStrMaze);	
		output.printMaze(bfsSolution);
		
		//BFS information
		output.printPath(bfs.shortestPath);
		output.printString("Elapsed time using BFS to solve maze of size " + mazeSize + ": " + elapsedTime + " ns\n\n");
		output.printString("Length of path: " + bfs.shortestPath.size() + "\n\n");
		output.printString("Visited cells: " + bfs.truePath.size() + "\n\n");

		
		output.printString("\nDFS:");
		currentMaze.resetMaze();
		
		//Solves the maze using DFS + get elapsed time
		elapsedTime = 0;
		start = System.nanoTime();
		dfs.solveMaze(currentMaze.maze);
		dfs.findShortestPath(currentMaze.maze, currentMaze.maze[0][0], currentMaze.maze[currentMaze.size-1][currentMaze.size-1]);
		end = System.nanoTime();
		elapsedTime = (end - start);
		
		//Prints DFS steps
		currentMaze.mazeSteps(dfs.truePath, currentStrMaze);
		output.printMaze(currentMaze.mazeSteps);

		
		//Print DFS solution
		String[][] dfsSolution = currentMaze.mazeHash(dfs.truePath, dfs.shortestPath, currentStrMaze);	
		output.printMaze(dfsSolution);
		
		//DFS information
		output.printPath(dfs.shortestPath);
		output.printString("Elapsed time using DFS to solve maze of size " + mazeSize + ": " + elapsedTime + " ns\n\n");
		output.printString("Length of path: " + dfs.shortestPath.size() + "\n\n");
		output.printString("Visited cells: " + dfs.truePath.size()+ "\n\n");
		
		assertEquals(bfs.getPath(), dfs.getPath());
		
		output.closeFile();
		
	}

	
	/* Given test cases */
	
	void getSolution(Maze testMaze) {
		System.out.println("Graph size: " + testMaze.size + "\n");
		System.out.println("BFS:\n");
		String[][] stringMaze = testMaze.stringMaze();
		testMaze.printMaze(stringMaze);
		
				
		bfs.solveMaze(testMaze.maze);
		bfs.findShortestPath(testMaze.maze, testMaze.maze[0][0], testMaze.maze[testMaze.size-1][testMaze.size-1]);
		
		//Print BFS with steps
		testMaze.mazeSteps(bfs.truePath, stringMaze);
		testMaze.printMaze(testMaze.mazeSteps);
		
		//Print BFS with hash
		String[][] withHash = testMaze.mazeHash(bfs.truePath, bfs.shortestPath, stringMaze);
		testMaze.printMaze(withHash);
		
		testMaze.resetMaze();
		
		System.out.println("DFS:\n");
		DFS dfs = new DFS();
		dfs.solveMaze(testMaze.maze);
		dfs.findShortestPath(testMaze.maze, testMaze.maze[0][0], testMaze.maze[testMaze.size-1][testMaze.size-1]);
		
		//Print BFS with steps
		testMaze.mazeSteps(dfs.truePath, stringMaze);
		testMaze.printMaze(testMaze.mazeSteps);

		//Print DFS with steps
		String[][] withHash2 = testMaze.mazeHash(dfs.truePath, dfs.shortestPath, stringMaze);
		testMaze.printMaze(withHash2);
		
		assertEquals(bfs.getPath(), dfs.getPath());
	}
	
	
	
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
	
	@Test 
	void test4x4() {
		int mazeSize = 4;
		Maze maze4x4 = new Maze(mazeSize);			
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
		getSolution(maze4x4);
				
	}
	
	
	/*
	 * + +-+-+-+-+-+
	 * |   |       |
	 * +-+ +-+-+-+ +
	 * | |       | |
	 * + +-+-+-+ + +
	 * |     | |   |
	 * + +-+ + +-+ +
	 * | |       | |
	 * + +-+-+-+-+ +
	 * |     |     |
	 * + +-+ + +-+-+
	 * |   |       |
	 * +-+-+-+-+-+ +
	 */
	@Test
	void test6x6() {
		int mazeSize = 6;
		Maze mazeTest = new Maze(mazeSize);
		mazeTest.removeWall(mazeTest.maze[0][0], mazeTest.maze[0][1]);
		mazeTest.removeWall(mazeTest.maze[0][1], mazeTest.maze[1][1]);
		mazeTest.removeWall(mazeTest.maze[1][2], mazeTest.maze[1][1]);
		mazeTest.removeWall(mazeTest.maze[1][2], mazeTest.maze[1][3]);
		mazeTest.removeWall(mazeTest.maze[1][4], mazeTest.maze[1][3]);
		mazeTest.removeWall(mazeTest.maze[1][4], mazeTest.maze[2][4]);
		mazeTest.removeWall(mazeTest.maze[2][5], mazeTest.maze[2][4]);
		mazeTest.removeWall(mazeTest.maze[2][5], mazeTest.maze[1][5]);
		mazeTest.removeWall(mazeTest.maze[0][5], mazeTest.maze[1][5]);
		mazeTest.removeWall(mazeTest.maze[0][5], mazeTest.maze[0][4]);
		mazeTest.removeWall(mazeTest.maze[0][3], mazeTest.maze[0][4]);
		mazeTest.removeWall(mazeTest.maze[0][3], mazeTest.maze[0][2]);
		mazeTest.removeWall(mazeTest.maze[2][5], mazeTest.maze[3][5]);
		mazeTest.removeWall(mazeTest.maze[4][5], mazeTest.maze[3][5]);
		mazeTest.removeWall(mazeTest.maze[4][5], mazeTest.maze[4][4]);
		mazeTest.removeWall(mazeTest.maze[4][3], mazeTest.maze[4][4]);
		mazeTest.removeWall(mazeTest.maze[4][3], mazeTest.maze[5][3]);
		mazeTest.removeWall(mazeTest.maze[5][4], mazeTest.maze[5][3]);
		mazeTest.removeWall(mazeTest.maze[5][5], mazeTest.maze[5][4]);
		mazeTest.removeWall(mazeTest.maze[5][3], mazeTest.maze[5][2]);
		mazeTest.removeWall(mazeTest.maze[5][2], mazeTest.maze[4][2]);
		mazeTest.removeWall(mazeTest.maze[4][1], mazeTest.maze[4][2]);
		mazeTest.removeWall(mazeTest.maze[4][1], mazeTest.maze[4][0]);
		mazeTest.removeWall(mazeTest.maze[5][0], mazeTest.maze[4][0]);
		mazeTest.removeWall(mazeTest.maze[5][0], mazeTest.maze[5][1]);
		mazeTest.removeWall(mazeTest.maze[3][0], mazeTest.maze[4][0]);
		mazeTest.removeWall(mazeTest.maze[3][0], mazeTest.maze[2][0]);
		mazeTest.removeWall(mazeTest.maze[1][0], mazeTest.maze[2][0]);
		mazeTest.removeWall(mazeTest.maze[2][1], mazeTest.maze[2][0]);
		mazeTest.removeWall(mazeTest.maze[2][1], mazeTest.maze[2][2]);
		mazeTest.removeWall(mazeTest.maze[3][2], mazeTest.maze[2][2]);
		mazeTest.removeWall(mazeTest.maze[3][2], mazeTest.maze[3][1]);
		mazeTest.removeWall(mazeTest.maze[3][2], mazeTest.maze[3][3]);
		mazeTest.removeWall(mazeTest.maze[3][4], mazeTest.maze[3][3]);
		mazeTest.removeWall(mazeTest.maze[2][3], mazeTest.maze[3][3]);
		getSolution(mazeTest);
		
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
