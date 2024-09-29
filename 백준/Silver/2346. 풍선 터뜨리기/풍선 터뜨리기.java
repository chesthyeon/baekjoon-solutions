import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.add(new int[]{i, Integer.parseInt(st.nextToken())});
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            sb.append(current[0]).append(" ");

            if (deque.isEmpty()) break;

            if (current[1] > 0) {
                for (int i = 0; i < current[1] - 1; i++) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < -current[1]; i++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb);
    }
}