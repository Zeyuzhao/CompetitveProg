import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SubwaySystem {
    public static void main(String[] args) throws IOException {
        // Before submitting, make sure the main method hasn't been changed!
        Scanner sc = new Scanner(new FileReader("SubwaySystemIN.txt"));
        while(sc.hasNext()) {
            int numOnTime = sc.nextInt();
            int totalServices = sc.nextInt();
            int threshold = sc.nextInt();
            System.out.println(computeOnTimePerformance(
                    numOnTime, totalServices, threshold));
        }
        sc.close();
    }
    
    //Fill out the body of this method
    public static boolean computeOnTimePerformance(
            int numOnTime, int totalServices, int threshold) {
        return ((100 * numOnTime / totalServices) >= threshold);
    }
}
