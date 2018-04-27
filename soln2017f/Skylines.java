import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Collections;
import java.util.stream.Collectors;

public class Skylines {
  // Before submitting, make sure the main method hasn't been changed!
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("SkylinesIN.txt"));
    while (br.ready()) {
      int N = Integer.parseInt(br.readLine());
      List<Building> buildings = new ArrayList<Building>();
      for (int i = 0; i < N; i++) {
        String[] data = br.readLine().split(",");
        int l = Integer.parseInt(data[0]);
        int h = Integer.parseInt(data[1]);
        int r = Integer.parseInt(data[2]);
        buildings.add(new Building(l, h, r));
      }
      List<Strip> strips = getSkyline(buildings);
      List<String> stripStrings = strips.stream()
        .map(strip -> "Strip(" + strip.left + ", " + strip.height + ")")
        .collect(Collectors.toList());
      String output = String.join(", ", stripStrings);
      System.out.println("[" + output + "]");
    }
    br.close();
  }

  public static class Building {
    public int left, right, height;
    public Building(int left, int height, int right) {
      this.left = left;
      this.right = right;
      this.height = height;
    }
  };

  public static class Strip {
    public int left, height;
    public Strip(int left, int height) {
      this.left = left;
      this.height = height;
    }
  };

  public static class Vert {
    public int x, y;
    public boolean isStart;
    public Vert(int x, int y, boolean isStart) {
      this.x = x;
      this.y = y;
      this.isStart = isStart;
    }
  };

  // Fill out the body of this method
  public static List<Strip> getSkyline(List<Building> buildings) {
    List<Vert> verts = new ArrayList<Vert>();
    for (Building building : buildings) {
      verts.add(new Vert(building.left, building.height, true));
      verts.add(new Vert(building.right, building.height, false));
    }
    Collections.sort(verts, (v1, v2) -> v1.x - v2.x);
    List<Strip> skyline = new ArrayList<Strip>();
    TreeMap<Integer, Integer> heights = new TreeMap<Integer, Integer>();
    int prevHeight = -1;
    int prevX = -1;
    for (Vert vert : verts) {
      if (vert.x != prevX) {
        if (prevX != -1) {
          int height;
          if (heights.size() == 0) {
            height = 0;
          } else {
            height = heights.lastKey();
          }
          if (height != prevHeight) {
            skyline.add(new Strip(prevX, height));
            prevHeight = height;
          }
        }
        prevX = vert.x;
      }
      if (vert.isStart) {
        if (!heights.containsKey(vert.y)) {
          heights.put(vert.y, 0);
        }
        heights.put(vert.y, heights.get(vert.y) + 1);
      } else {
        heights.put(vert.y, heights.get(vert.y) - 1);
        if (heights.get(vert.y) <= 0) {
          heights.remove(vert.y);
        }
      }
    }
    skyline.add(new Strip(prevX, 0));
    return skyline;
  }
}
