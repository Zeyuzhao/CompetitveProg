import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class HistoricReconstruction {
  // Called once at the start of each test case.
  // Don't forget to reset any data structures you might be using!
  static ArrayList<TreeMap<Integer, Integer>> sizes;
  static ArrayList<Integer> mergeTime;
  static ArrayList<Integer> mergeParent;

  private static void initialize(int N, int Q) {
    sizes = new ArrayList<TreeMap<Integer, Integer>>();
    mergeTime = new ArrayList<Integer>();
    mergeParent = new ArrayList<Integer>();
    for (int i = 0; i < N; i++) {
      sizes.add(new TreeMap<Integer, Integer>());
      sizes.get(i).put(0, 1);
      mergeTime.add(null);
      mergeParent.add(null);
    }
    return;
  }

  private static int getRoot(int x, int t) {
    if (mergeParent.get(x) == null) {
      return x;
    }
    if (mergeTime.get(x) > t) {
      return x;
    }
    // System.out.println("walking up " + x + " to " + mergeParent.get(x) + " size " + sizes.get(x).lastEntry().getValue());
    return getRoot(mergeParent.get(x), t);
  }

  // Adds a road between landmarks a and b, which finishes building at time t.
  // t is guaranteed to start at 1 and increase by 1 every subsequent call.
  private static void addRoad(int a, int b, int t) {
    // System.out.printf("addRoad(%d, %d, %d)\n", a, b, t);
    a--;
    b--;
    int parA = getRoot(a, t);
    int parB = getRoot(b, t);
    if (parA == parB) {
      return;
    }
    int size1 = sizes.get(parA).lastEntry().getValue();
    int size2 = sizes.get(parB).lastEntry().getValue();
    if (size1 < size2) {
      int temp = parA;
      parA = parB;
      parB = temp;
    }
    // Merge parB into parA
    mergeTime.set(parB, t);
    mergeParent.set(parB, parA);
    sizes.get(parA).put(t, size1 + size2);
    return;
  }

  // At a previous time t, how many landmarks are reachable from x using
  // roads that existed at that time?
  // t is guaranteed to be at most as large as the biggest t seen by addRoad.
  private static int reachable(int x, int t) {
    // System.out.printf("reachable(%d, %d)\n", x, t);
    x--;
    int par = getRoot(x, t);
    return sizes.get(par).floorEntry(t).getValue();
  }

  /* DO NOT MODIFY BELOW THIS LINE */
  private static class RNG {
    private byte[] S;

    private RNG(byte[] S) {
      this.S = S;
    }

    private long getNextRand(String V) throws NoSuchAlgorithmException {
      byte[] byteV = V.getBytes(StandardCharsets.US_ASCII);
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(this.S);
      md.update(byteV);
      this.S = md.digest();
      long t = (long) this.S[0] & 0xff;
      t += ((long) this.S[1] & 0xff) << 8;
      t += ((long) this.S[2] & 0xff) << 16;
      t += ((long) this.S[3] & 0xff) << 24;
      return t;
    }
  }

  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
    BufferedReader br = new BufferedReader(new FileReader("HistoricReconstructionIN.txt"));
    while (br.ready()) {
      String[] data = br.readLine().split(" ");
      if (data.length == 0) {
        break;
      }
      int N = Integer.parseInt(data[0]);
      int Q = Integer.parseInt(data[1]);
      String S = data[2];
      int PROP_ADD_ROAD = Integer.parseInt(data[3]);
      RNG R = new RNG(S.getBytes(StandardCharsets.US_ASCII));
      String lastVal = "0";
      initialize(N, Q);
      int T = 0;
      for (int i = 0; i < Q; i++) {
        long r = R.getNextRand(lastVal);
        if (r % 100 < PROP_ADD_ROAD) {
          // addRoad
          int a = (int) (R.getNextRand(lastVal) % N) + 1;
          int b = (int) (R.getNextRand(lastVal) % N) + 1;
          if (a == b) {
            b = (b + 1) % N + 1;
          }
          T++;
          // System.out.printf("addRoad(%d, %d, %d)\n", a, b, T);
          addRoad(a, b, T);
          lastVal = "0";
        } else {
          // reachable
          int x = (int) (R.getNextRand(lastVal) % N) + 1;
          int t = (int) (R.getNextRand(lastVal) % (T + 1));
          // System.out.printf("reachable(%d, %d)\n", x, t);
          lastVal = Integer.toString(reachable(x, t));
          System.out.println(lastVal);
        }
      }
    }
    br.close();
  }
  /* DO NOT MODIFY ABOVE THIS LINE */
}
