import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RubyBridge {
    public static void main(String[] args) throws IOException {
        // Before submitting, make sure the main method hasn't been changed!
        Scanner sc = new Scanner(new FileReader("RubyBridgeIN.txt"));
        while(sc.hasNext()) {
            int n = sc.nextInt();
            String charList = sc.next();
            char[] list = new char[n];
            for(int i = 0; i < n; i++) {
                list[i] = charList.charAt(i);
            }
            System.out.println(rubyBridge(n, list));
        }
        sc.close();
    }
    
    public static int rubyBridge(int n, char[] list) {
        int maxLength = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for(int i = 0; i < list.length; i++) {
            count = (list[i] == 'P') ? count + 1 : count - 1;
            if(map.containsKey(count)) 
                maxLength = Math.max(maxLength, i - map.get(count));
            else
                map.put(count, i);
        }
        return maxLength;
    }
}
