package other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GrahamScan {
    public static void main(String[] args){
        Point points[] = new Point[7];
        points[0]=new Point(0, 3);
        points[1]=new Point(2, 3);
        points[2]=new Point(1, 1);
        points[3]=new Point(2, 1);
        points[4]=new Point(3, 0);
        points[5]=new Point(0, 0);
        points[6]=new Point(3, 3);
        List<Point> inList = new ArrayList<>(Arrays.asList(points));
        //Choose the leftmost point as a pivot, and then sorts the points by increasing CCW.
        int firstIndex = leftMostPoint(inList);
        Point firstPoint = inList.remove(firstIndex);
        inList.sort(new RadialSort(firstPoint));
        System.out.println("First Point: " + firstPoint);
        System.out.println(inList);
    }

    public static int leftMostPoint(List<Point> inList){
        double smallestX = inList.get(0).x;
        int leftMostIndex = 0;
        for (int i = 0; i < inList.size(); i++){
            if (inList.get(i).x < smallestX){
                leftMostIndex = i;
                smallestX = inList.get(i).x;
            }
        }
        return leftMostIndex;
    }

    public static List<Point> grahamScan(List<Point> pointList){
        int firstIndex = leftMostPoint(pointList);
        Point firstPoint = pointList.remove(firstIndex);
        pointList.sort(new RadialSort(firstPoint));
        return null;
    }

}
