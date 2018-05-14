package other.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] list) {
        for (int i = 0; i < list.length - 2; i++) {
            //Find min
            int minIndex = i;
            for (int j = i; j < list.length - 1; j++) {
                if (list[j] < list[minIndex]) {
                    minIndex = j;
                }
            }
            //swap
            int temp = list[minIndex];
            list[minIndex] = list[i];
            list[i] = temp;
        }
    }
    public static void main(String[] args){
        int[] test = {1,3,5,6,3,4,6,7,9};

        SelectionSort.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
