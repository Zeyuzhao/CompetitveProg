package other.sort;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.Arrays;

public class MergeSort {
    public static int[] merge(int[] a, int[] b){
        int resultLength = a.length + b.length;
        int[] result = new int[resultLength];
        int ai = 0;
        int bi = 0;
        int ri = 0;
        while(ai < a.length && bi < b.length){
            if (a[ai] < b[bi]){
                result[ri] = a[ai];
                ai++;
            } else {
                result[ri] = b[bi];
                bi++;
            }
            ri++;
        }
        while (ai < a.length){
            result[ri] = a[ai];
            ai++;
            ri++;
        }
        while (bi < b.length){
            result[ri] = b[bi];
            bi++;
            ri++;
        }
        return result;
    }

    public static int[] sort(int[] list)
    {
        if (list.length <= 1){
            return list;
        }
        int split = list.length / 2;

        int[] a = Arrays.copyOfRange(list,0, split);
        int[] b = Arrays.copyOfRange(list, split, list.length);
        return merge(sort(a), sort(b));
    }
    public static void main(String[] args){
        int[] first = {1,6,3,4,6,3,9,6,0, 8,3,20, -10};
        int[] result = MergeSort.sort(first);
        System.out.println(Arrays.toString(result));
    }
}
