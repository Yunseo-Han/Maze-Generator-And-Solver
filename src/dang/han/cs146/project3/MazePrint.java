package dang.han.cs146.project3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MazePrint {
	BufferedWriter bw;
	
	/*
	 * Creates new file. 
	 */
	public MazePrint(String filepath) throws IOException {
		File file = new File(filepath);
			file.createNewFile();
			bw = new BufferedWriter(new FileWriter(file));	// true => append mode
	}
	
	/*
	 * Write string maze in respective file.
	 */
	public void printMaze(String[][] stringMaze) throws IOException {
		bw.write("\n");
		
		for (int row = 0; row < stringMaze.length; row++) {
			for (int col = 0; col < stringMaze.length; col++) {
				bw.write(stringMaze[row][col]);
			}
			bw.write("\n");
		}
		
		bw.write("\n\n");
	}
	
	/*
	 * Write path in respective file.
	 */
	public void printPath(ArrayList<Node> path) throws IOException {
		bw.write("Path:");
		for (int i=0; i<path.size(); i++) {
			bw.write("("+ path.get(i).col + ", " + path.get(i).row + ") ");
		}
		
		bw.write("\n\n");
	}
	
	/*
	 * Writes input into respective file.
	 */
	public void printString(String str) throws IOException {
		bw.write(str);
	}
	
	
	public void closeFile() throws IOException {
			bw.close();
	}
	

}
