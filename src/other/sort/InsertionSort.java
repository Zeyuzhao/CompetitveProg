package other.sort;

import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    public static void sort(int[] list)
    {
        for (int i = 1; i < list.length; i++){
            int val = list[i];
            int c = i - 1;
            //Continue moving down the list until it is no longer smaller or reaches the beginning
            while (c >= 0 && val < list[c]){
                int temp = list[c + 1];
                list[c + 1] = list[c];
                list[c] = temp;
                c--;
            }
        }
    }
    public static void main(String[] args){
        int[] test = {1,3,5,6,3,4,6,7,9};

        InsertionSort.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
