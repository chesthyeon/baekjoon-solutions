import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cur = 1;
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++){
            int target = Integer.parseInt(br.readLine());
            while (cur <= target){
                stack.push(cur);
                sb.append("+").append("\n");
                cur++;
            }
            if (stack.isEmpty() || stack.peek() != target){
                flag = false;
                break;
            }
            stack.pop();
            sb.append("-").append("\n");
        }
        System.out.print(flag ? sb : "NO");

    }
}