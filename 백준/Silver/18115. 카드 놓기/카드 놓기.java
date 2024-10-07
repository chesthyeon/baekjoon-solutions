import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cmd = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<Integer> deque = new LinkedList<>();

        for (int i = N - 1; i >= 0; i--) {
            int card = N - i;
            switch (cmd[i]) {
                case 1 :
                    deque.offerFirst(card);
                    break;
                case 2:
                    int temp = deque.pollFirst();
                    deque.offerFirst(card);
                    deque.offerFirst(temp);
                    break;
                case  3 :
                    deque.offerLast(card);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.poll()).append(" ");
        }

        System.out.println(sb);
    }
}
