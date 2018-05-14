package other.sort;

import java.util.Arrays;
import java.util.InputMismatchException;

public class QuickSort {
    private static int counter=0;
    protected static int partition(int[] list, int start, int end)
    {
        return partition(list, start, end, end - 1);
    }
    //Choose the location of the pivot
    protected static int partition(int[] list, int start, int end, int pivot)
    {
        int r = end - 1;
        swap(list, pivot, r);
        int rVal = list[r];
        int q = start;
        for (int i = start; i < r; i++)
        {
            if (list[i] <= rVal){
                //System.out.format("Swap %d, %d\n", i, q);
                swap(list, i, q);
                q++;
            }
            counter++;
        }
        swap(list, r, q);

        return q;
    }
    protected static void sortHelper(int[] list, int a, int b){
        if (a < b){
            int p = QuickSort.partition(list, a, b);
            QuickSort.sortHelper(list, a, p);
            QuickSort.sortHelper(list, p + 1, b);
        }
    }
    protected static void swap(int[] list, int a, int b){
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

    public static void sort(int[] list){
        QuickSort.sortHelper(list, 0, list.length);
    }

    public static void main(String[] args){
        int[] first = {1,6,0,5,4,3,2,3,3,4,10,1,2,2};
        QuickSort.sortHelper(first, 0, first.length);
        System.out.println(Arrays.toString(first));
        System.out.println("Counter: " + counter);
    }

}
