package other.sort;

import java.util.Arrays;
import java.util.Random;

public class SortTester {
    public static int[] genRandList(int length, int range){
        int[] ans = new int[length];
        Random gen = new Random();
        for (int i = 0; i < length; i++)
        {
            ans[i] = gen.nextInt(range);
        }
        return ans;
    }
    public static int[] genRandShuffle(int length)
    {
        int[] ans = new int[length];
        for (int i = 0; i < length; i++)
        {
            ans[i] = i;
        }
        Random gen = new Random();
        for (int i = length; i > 0; i--)
        {
            int randI = gen.nextInt(i);
            int temp = ans[randI];
            ans[randI] = ans[i - 1];
            ans[i - 1] = temp;
        }
        return ans;
    }
    public static void main(String[] args)
    {
        for(int i = 0; i < 50; i++){
            int[] randList = SortTester.genRandList(10000, 15);
            int[] shuffle = SortTester.genRandShuffle(10000);
            InsertionSort.sort(randList);
            InsertionSort.sort(shuffle);
            System.out.println("Rand: " + Arrays.toString(randList));
            System.out.println("Shuffle: " + Arrays.toString(shuffle));
        }
    }
}
