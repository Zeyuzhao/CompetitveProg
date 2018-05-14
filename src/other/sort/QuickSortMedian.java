package other.sort;

import java.util.Arrays;

public class QuickSortMedian extends QuickSort{

    protected static int partition(int[] list, int start, int end)
    {
        int a = list[start];
        int b = list[(start + end) / 2];
        int c = list[end - 1];
        int x = median(a, b, c);
        int ans;
        if (a == x)
        {
            ans = start;
        } else if (c == x)
        {
            ans = end - 1;
        } else
        {
            ans = (start + end) / 2;
        }
        return partition(list, start, end, ans);
    }
    protected static int median(int x, int y, int z)
    {
        int[] ans = {x,y,z};
        //Use any algorithm to sort the three.
        Arrays.sort(ans);
        return ans[1];
    }
    public static void main(String[] args){
        int[] first = {1,6,0,5,4,3,2,3,3,4,10,1,2,2};
        QuickSortMedian.sortHelper(first, 0, first.length);
        System.out.println(Arrays.toString(first));
        System.out.println();
    }
}
