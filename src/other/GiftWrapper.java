package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GiftWrapper {

    public static final double EPISLON = 1e-7;


    public static List<Point> giftWrapper(List<Point> pointList){
        //Get the left most point
        double smallestX = pointList.get(0).x;
        int leftMostIndex = 0;
        for (int i = 0; i < pointList.size(); i++){
            if (pointList.get(i).x < smallestX){
                 leftMostIndex = i;
                 smallestX = pointList.get(i).x;
            }
        }

        List<Point> hull = new ArrayList<>();

        int currentPoint = leftMostIndex;
        int nextPoint;
        do {
            hull.add(pointList.get(currentPoint));
            nextPoint = (currentPoint + 1) % pointList.size();
            for(int i = 0; i < pointList.size(); i++){
                if (isCCW(pointList.get(currentPoint), pointList.get(nextPoint), pointList.get(i)) > 0){
                    nextPoint = i;
                }
            }
            currentPoint = nextPoint;
        } while(nextPoint != leftMostIndex);
        return hull;
    }

    public static int isCCW(Point p, Point q, Point r){
        double cross = (q.x - p.x) * (r.y - p.y) - (q.y - p.y) * (r.x - p.x);

        if (cross > EPISLON){ // is counter clockwise
            return 1;
        } else if (cross < -EPISLON){ // is clockwise
            return -1;
        } else { // is collinear
            return 0;
        }
    }

    public static void main(String[] args){
        //Check if CCW actually works
//        Point[] points = {
//                new Point(0,0),
//                new Point(2, 2),
//                new Point(2, 0),
//                new Point(1, 1),
//                new Point(0, 2)
//        };
        Point points[] = new Point[7];
        points[0]=new Point(0, 3);
        points[1]=new Point(2, 3);
        points[2]=new Point(1, 1);
        points[3]=new Point(2, 1);
        points[4]=new Point(3, 0);
        points[5]=new Point(0, 0);
        points[6]=new Point(3, 3);
        List<Point> inList = new ArrayList<>(Arrays.asList(points));
        System.out.println(giftWrapper(inList));
        System.out.println(isCCW(new Point(2, 2), new Point(2, 0), new Point(0,0 )));
    }

}
