import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;
        for (int target : targets) {
            int index = deque.indexOf(target);
            int halfSize = deque.size() / 2;

            if (index <= halfSize) {
                for (int i = 0; i < index; i++) {
                    int num = deque.pollFirst();
                    deque.offerLast(num);
                    cnt++;
                }
            } else {
                for (int i = 0; i < deque.size() - index; i++) {
                    deque.offerFirst(deque.pollLast());
                    cnt++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(cnt);
    }
}
