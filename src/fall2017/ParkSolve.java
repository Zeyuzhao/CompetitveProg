package fall2017;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParkSolve {
    public static void main(String[] args){
        try {
            Scanner reader = new Scanner(new File("soln2017f//StressfulParkIN.txt"));
            while(reader.hasNext()) {
                String firstLine = reader.nextLine();
                String[] firstPair = firstLine.split(" ");

                int m = Integer.parseInt(firstPair[0]);
                int n = Integer.parseInt(firstPair[1]);

                int[][] parkValues = new int[m][n];
                for (int i = 0; i < m; i++) {
                    String currentLine = reader.nextLine();
                    String[] tempList = currentLine.split(" ");
                    for (int j = 0; j < n; j++) {
                        parkValues[i][j] = Integer.parseInt(tempList[j]);
                    }
                }
                System.out.println(solvePark(parkValues, m, n));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static int solvePark(int[][] park, int m, int n){

        int[][] parkCost = new int[m][n]; //A helper matrix that stores all the moves required to get to point i,j
        parkCost[0][0] = 0; //Initialize the origin

        //Initialize the sides of the helper matrix
        for (int i = 1; i < m; i++){
            parkCost[i][0] = parkCost[i - 1][0] + park[i][0];
        }
        for (int j = 1; j < n; j++){
            parkCost[0][j] = parkCost[0][j - 1] + park[0][j];
        }

        //Fill in the entire matrix by comparing the previous squares, and finding the minimum cost.
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                parkCost[i][j] = Math.min(parkCost[i - 1][j], parkCost[i][j - 1]) + park[i][j];
            }
        }
        return parkCost[m - 1][n - 1];
    }

}
