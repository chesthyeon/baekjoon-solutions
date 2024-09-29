import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        Stack<Character> stack = new Stack<>();
        int result = 0;
        
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (input.charAt(i-1) == '(') {
                    // 레이저인 경우
                    result += stack.size();
                } else {
                    // 쇠막대기의 끝인 경우
                    result += 1;
                }
            }
        }
        
        System.out.println(result);
    }
}