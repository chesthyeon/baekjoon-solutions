import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGoodWord(word)) {
                count++;
            }
        }
        
        bw.write(String.valueOf(count));
        bw.newLine();
        
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static boolean isGoodWord(String word) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : word.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}