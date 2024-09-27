import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd){
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    sb.append(stack.isEmpty()? -1 : stack.pop()).append("\n");
                    break;
                case "size" :
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty" :
                    sb.append(stack.isEmpty()? 1 : 0).append("\n");
                    break;
                case "top" :
                    sb.append(stack.isEmpty()? -1 : stack.peek()).append("\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}