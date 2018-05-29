package practice;

import java.util.ArrayList;
import java.util.List;

public class RainWater {
    public static int trap(int[] bars) {
        int leftHighest = 0;
        int leftMaxes[] = new int[bars.length];

        //Find the highest left side bar of each bar
        for (int i = 0; i < bars.length; i++)
        {
            if (bars[i] >= leftHighest)
            {
                //Set to zero because that bar cannot have any water on top
                leftMaxes[i] = 0;
                //Find the current highest left bar
                leftHighest = bars[i];
            } else {
                // The bar is smaller than its left highest bar

                leftMaxes[i] = leftHighest;
            }
        }

        int rightHighest = 0;
        int[] rightMaxes = new int[bars.length];
        for (int i = bars.length - 1; i >= 0; i--)
        {
            if (bars[i] >= rightHighest)
            {
                //Set to zero because that bar cannot have any water on top
                rightMaxes[i] = 0;
                //Find the current highest left bar
                rightHighest = bars[i];
            } else {
                // The bar is smaller than its left highest bar
                rightMaxes[i] = rightHighest;
            }
        }

        int rainTotal = 0;
        for (int i = 0; i < bars.length; i++)
        {
            //Check if water can exist on top
            if (leftMaxes[i] > 0 && rightMaxes[i] > 0)
            {
                int height = Math.min(leftMaxes[i], rightMaxes[i]) - bars[i];
                System.out.format("Bar %d: %d\n", i, height);
                rainTotal += height;
            }
        }

        return rainTotal;
    }

    public static void main(String[] args) {
        int[] bars1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(bars1));
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.set(1,"c");
        list.add(2, "d");
        list.set(2, "e");
        list.add("g");
        System.out.println(list);
    }
}
