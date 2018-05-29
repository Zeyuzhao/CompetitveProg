package practice.ap_bag;

import java.util.ArrayList;

public class Digits {
    private ArrayList<Integer> digitList;

    public Digits(int num)
    {
        intToArrayString(num);
    }

    public void intToArray(int num)
    {
        digitList = new ArrayList<>();
        if (num == 0){
            digitList.add(0);
        }
        while (num > 0)
        {
            int currentDigit = num % 10;
            digitList.add(0, currentDigit);
            num /= 10;
        }
    }

    public void intToArrayString(int num)
    {
        digitList = new ArrayList<>();
        String numString = Integer.toString(num);
        char[] numChars = numString.toCharArray();
        for (char c : numChars)
        {
            digitList.add(c - '0');
        }
    }

    public void printList()
    {
        for (Integer i : digitList)
        {
            System.out.print(i + " ");
        }
    }

    public boolean strictlyIncreasing()
    {
        if (digitList.size() < 2)
        {
            return true;
        }
        int prev = 0;
        for (Integer i : digitList)
        {
            if (i <= prev)
            {
                return false;
            }
            prev = i;
        }
        return true;
    }

    public static void main(String[] args) {
        Digits twelve = new Digits(23456);
        twelve.printList();
        System.out.println(twelve.strictlyIncreasing());
    }
}
