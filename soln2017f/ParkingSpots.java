import java.util.*;
import java.io.*;

class ParkingSpots {
	
    private static class Neighborhood {
	    int start;
	    int end;
	    Neighborhood() { start = 0; end = 0; }
	    Neighborhood(int s, int e) { start = s; end = e; }

	    public String toString() {
	    	return "[" + this.start + ", " + this.end + "]";
	    }
    }


	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("ParkingSpotsIN.txt"));
		while (sc.hasNextLine()) {
			int N = sc.nextInt();
			List<Neighborhood> neighborhoods = new ArrayList<Neighborhood>();
			for (int i = 0; i < N; i++) {
				int s = sc.nextInt(), e = sc.nextInt();
				Neighborhood interval = new Neighborhood(s, e);
				neighborhoods.add(interval);
			}
			System.out.println(merge(neighborhoods));
		}
	}


	public static List<Neighborhood> merge(List<Neighborhood> intervals) {
    	if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        List<Neighborhood> result = new ArrayList<Neighborhood>();
        Collections.sort(intervals, (i, j) -> Integer.compare(i.start, j.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Neighborhood interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                result.add(new Neighborhood(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Neighborhood(start, end));
        return result;    
    }

}