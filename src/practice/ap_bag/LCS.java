package practice.ap_bag;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        System.out.println(solveLCS("sea", "eat"));
    }

    public static String solveLCS(String a, String b)
    {
        if (a.length() == 0 || b.length() == 0){
            return "";
        }
        int[][] helperMat = new int[a.length()][b.length()];

        //Initialize the edges
        //Init row
        boolean matched = false;
        for (int i = 0; i < b.length(); i++)
        {
            if (a.charAt(0) == b.charAt(i))
            {
                matched = true;
            }
            if (matched)
                helperMat[0][i] = 1;
            else
                helperMat[0][i] = 0;
        }
        //init col
        matched = false;
        for (int i = 0; i < a.length(); i++)
        {
            if (b.charAt(0) == a.charAt(i))
            {
                matched = true;
            }
            if (matched)
                helperMat[i][0] = 1;
            else
                helperMat[i][0] = 0;
        }

        for (int i = 1; i < a.length(); i++)
        {
            for(int j = 1; j < b.length(); j++)
            {
                if (a.charAt(i) == b.charAt(j))
                {
                    helperMat[i][j] = helperMat[i - 1][j - 1] + 1;
                } else {
                    helperMat[i][j] = Math.max(helperMat[i - 1][j], helperMat[i][j - 1]);
                }
            }
        }
        System.out.println(Arrays.deepToString(helperMat));
        int x = a.length() - 1;
        int y = b.length() - 1;

        String common = "";
        while(x >= 1 && y >=1){
            int currentVal = helperMat[x][y];
            if (helperMat[x - 1][y] == currentVal){
                x--;
                continue;
            }
            if (helperMat[x][y - 1] == currentVal){
                y--;
                continue;
            }
            common = a.charAt(x) + common;
            x--;
            y--;
        }

        while (x != 0 && helperMat[x][0] == 1)
        {
            x--;
            if (helperMat[x][0] == 0)
            {
                common = a.charAt(x + 1) + common;
                break;
            }
        }
        while (y != 0 && helperMat[0][y] == 1)
        {
            y--;
            if (helperMat[0][y] == 0)
            {
                common = b.charAt(y + 1) + common;
                break;
            }
        }
        if (helperMat[0][0] == 1)
        {
            common = a.charAt(0) + common;
        }
        return common;

    }
}
