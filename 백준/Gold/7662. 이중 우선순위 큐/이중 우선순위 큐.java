import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());
            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if (cmd.equals("I")) {
                    treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
                } else if (!treeMap.isEmpty()) {
                    int key = num == 1 ? treeMap.firstKey() : treeMap.lastKey();
                    if (treeMap.put(key, treeMap.get(key) - 1) == 1) {
                        treeMap.remove(key);
                    }
                }
            }
            System.out.println(treeMap.isEmpty()? "EMPTY" : treeMap.firstKey() +" " + treeMap.lastKey());
        }
    }
}