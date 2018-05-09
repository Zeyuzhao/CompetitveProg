package practice;

import java.util.Stack;

public class MaxRectHist {
    public static void main(String[] args) {
        int[] test1 = {2,1,2};
        System.out.println(findRectArea(test1));
    }

    public static int findRectArea(int[] hist)
    {
        if (hist.length < 1)
        {
            return 0;
        }
        Stack<Integer> pos = new Stack<>();
        Stack<Integer> height = new Stack<>();
        pos.push(0);
        height.push(hist[0]);
        int maxArea = hist[0]; // Initialize the max area with the first bar
        for (int i = 1; i < hist.length; i++)
        {
            int currentPos = i;
            while (!height.isEmpty() && hist[i] <= height.peek())
            {
                int h = height.pop();
                int p = pos.pop();
                maxArea = Math.max(maxArea, (i - p) * h); //Set maxArea to the biggest of all possible rectangles
                currentPos = p;
            }
            pos.push(currentPos);
            height.push(hist[i]);
        }
        while (!pos.isEmpty())
        {
            int h = height.pop();
            int p = pos.pop();
            maxArea = Math.max(maxArea, (hist.length - p) * h); //Set maxArea to the biggest of all possible rectangles
        }
        return maxArea;
    }
}
