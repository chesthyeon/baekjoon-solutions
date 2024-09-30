import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> queue = new TreeMap<>();
            
            for (int i = 0; i < k; i++) {
                String[] input = br.readLine().split(" ");
                char operation = input[0].charAt(0);
                int n = Integer.parseInt(input[1]);
                
                if (operation == 'I') {
                    queue.put(n, queue.getOrDefault(n, 0) + 1);
                } else if (!queue.isEmpty()) {
                    int key = n == 1 ? queue.lastKey() : queue.firstKey();
                    if (queue.put(key, queue.get(key) - 1) == 1) {
                        queue.remove(key);
                    }
                }
            }
            
            if (queue.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                bw.write(queue.lastKey() + " " + queue.firstKey() + "\n");
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}