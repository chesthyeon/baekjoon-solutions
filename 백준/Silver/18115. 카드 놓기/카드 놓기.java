import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int[] skills = Arrays.stream(br.readLine().split(" "))
                             .mapToInt(Integer::parseInt)
                             .toArray();
        
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = N - 1; i >= 0; i--) {
            int card = N - i;
            switch (skills[i]) {
                case 1:
                    deque.offerFirst(card);
                    break;
                case 2:
                    int temp = deque.pollFirst();
                    deque.offerFirst(card);
                    deque.offerFirst(temp);
                    break;
                case 3:
                    deque.offerLast(card);
                    break;
            }
        }
        
        while (!deque.isEmpty()) {
            bw.write(deque.pollFirst() + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}