import java.io.FileReader;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.*;

public class TowerTycoon {
    public static void main(String[] args) throws IOException {
        HashMap<String, List<String>> vertexMap = new HashMap<>();
        Scanner sc = new Scanner(new FileReader("TowerTycoonIN.txt"));
        while(sc.hasNext()) {
            int numberOfLists = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < numberOfLists; i++) {
                String line = sc.nextLine();
                String[] inhabitants = line.split(" ");
                for (int j = 0; j < inhabitants.length - 1; j++) {
                    if (vertexMap.containsKey(inhabitants[j])) {
                        List<String> keyList = vertexMap.get(inhabitants[j]);
                        keyList.add(inhabitants[j+1]);
                        vertexMap.put(inhabitants[j], keyList);
                    } else {
                        List<String> list = new LinkedList<String>();
                        list.add(inhabitants[j+1]);
                        vertexMap.put(inhabitants[j], list);
                    }
                }
            }
            tower(vertexMap);
            vertexMap = new HashMap<String, List<String>>();
        }
        sc.close();

    }
    static void tower(Map<String, List<String>> map) {
        HashMap<String, Integer> getIndegree = new HashMap<String, Integer>();
        Queue<String> queue = new PriorityQueue<String>();
        List<String> list = new LinkedList<String>();
        for (String y : map.keySet()) {
            for (String x : map.get(y)) {
                if (getIndegree.containsKey(x)) {
                    int size = getIndegree.get(x);
                    size++;
                    getIndegree.put(x, size);
                } else {
                    getIndegree.put(x, 1);
                }
            }
        }
        for (String z : map.keySet()) {
            if (!(getIndegree.containsKey(z))) {
                queue.add(z);
            }
        }
        while(!(queue.isEmpty())){
            String next = queue.poll();
            list.add(next);
            if (map.containsKey(next)) {
                for (String vertex : map.get(next)) {
                    int total = getIndegree.get(vertex);
                    total--;
                    if (total == 0) {
                        queue.add(vertex);
                    } else {
                        getIndegree.put(vertex, total);
                    }
                }
            }
        }
        System.out.println(list);
        return;
    }
}