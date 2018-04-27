import java.io.*;
import java.util.*;

public class Perfect {
  public static void main(String[] args) throws IOException {

      Scanner sc = new Scanner(new FileReader("PerfectIN.txt"));
      while (sc.hasNext()) {
        System.out.println(isPerfect(sc.nextInt()));
      }

  }

  public static boolean isPerfect(int n) {
    if (n <= 0)
      return false;

    int sum = 0;

    for (int i = 1; i <= Math.sqrt(n); i++) {
      if (n % i == 0) {
        sum += i;
        if (i * i != n)
          sum += n / i;
      }
    }

    return (sum - n) == n;
  }
}
