import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd){
                case "push_back" :
                    deque.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case "push_front" :
                    deque.offerFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front" :
                    sb.append(deque.isEmpty()? -1 : deque.pollFirst()).append("\n");
                    break;
                case "pop_back" :
                    sb.append(deque.isEmpty()? -1 : deque.pollLast()).append("\n");
                    break;
                case "size" :
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front" :
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
                    break;
                case "back" :
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}