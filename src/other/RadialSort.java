package other;

import java.util.Comparator;

public class RadialSort implements Comparator<Point> {
    public static final double EPISLON = 1e-4;

    private Point pivot;
    public RadialSort(Point pivot){
        this.pivot = new Point(pivot);
    }
    @Override

    //Test if Point a has a greater angle than b with respect to the pivot point
    public int compare(Point a, Point b) {

        double negCross = (a.y - pivot.y) * (b.x - pivot.x) - (a.x - pivot.x) * (b.y - pivot.y);

        if (Math.abs(negCross) < EPISLON){
            return 0;
        } else if(negCross > 0){
            return 1;
        } else {
            return -1;
        }
    }
}
