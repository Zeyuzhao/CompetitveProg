package fall2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StressfulPark {

	public static void main(String[] args) throws FileNotFoundException {
		
		 Scanner fileInput = new Scanner(new File("soln/StressfulParkIN.txt"));
		 
		 while(fileInput.hasNext()) {

			 String inputStr = fileInput.nextLine().trim();
			 String[] inputStrArr = inputStr.split(" ");
			 int N = Integer.parseInt(inputStrArr[0]);
			 int M = Integer.parseInt(inputStrArr[1]);
			 
			 int[][] parkGrid = new int[N][M];
			 
			 for(int i = 0; i < N; i++) {
				 String[] nextRow = fileInput.nextLine().trim().split(" ");
				 
				 for(int j = 0; j < M; j++) {
					 parkGrid[i][j] = Integer.parseInt(nextRow[j]);
				 }
			 }
			 
			 System.out.println(shortestTimeToExit(parkGrid));
			 
		 }
	     fileInput.close();
		 
	}
	
	public static int shortestTimeToExit(int[][] parkGrid) {
		
		int[][] shortestTimeTo = new int[parkGrid.length][parkGrid[0].length];
		
		for(int i = 0; i < parkGrid.length; i++) {
			for(int j = 0; j < parkGrid[i].length; j++) {
				if(i == 0 && j == 0) {
					shortestTimeTo[i][j] = 0;
				} else if(i == 0) {
					shortestTimeTo[i][j] = shortestTimeTo[i][j - 1] + parkGrid[i][j];
				} else if(j == 0) {
					shortestTimeTo[i][j] = shortestTimeTo[i - 1][j] + parkGrid[i][j];
				} else {
					shortestTimeTo[i][j] = Math.min(shortestTimeTo[i][j - 1], 
							shortestTimeTo[i - 1][j]) + parkGrid[i][j];
				}
			}
		}
		
		return shortestTimeTo[parkGrid.length - 1][parkGrid[0].length - 1];
	}
	
}
