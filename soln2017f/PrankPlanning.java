import java.util.*;
import java.io.*;

class PrankPlanning {
	
	public static void main(String[] args) throws FileNotFoundException {
			
		Scanner sc = new Scanner(new FileReader("PrankPlanningIN.txt"));
		while (sc.hasNext()) {
			int N = sc.nextInt();
			for (int i = 0; i < N; i++) {
				System.out.println(reverse(sc.next()));
			}
		}

	}

	public static String reverse(String s) {
		String rev = "";
		for (int i = 0; i < s.length(); i++) {
			rev = s.charAt(i) + rev;
		}
		return rev;
	}

}