import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String number = br.readLine();

        // 스택 역할을 할 StringBuilder
        StringBuilder stack = new StringBuilder();
        int removeCount = 0; // 제거한 숫자 개수

        for (int i = 0; i < N; i++) {
            char currentDigit = number.charAt(i);

            // 현재 숫자가 스택 맨 위보다 크고, 아직 제거할 수 있다면
            while (stack.length() > 0 &&
                    stack.charAt(stack.length() - 1) < currentDigit &&
                    removeCount < K) {
                stack.deleteCharAt(stack.length() - 1); // 스택에서 제거
                removeCount++;
            }

            stack.append(currentDigit); // 현재 숫자 추가
        }

        // 아직 K개를 다 제거하지 못했다면 뒤에서부터 제거
        while (removeCount < K) {
            stack.deleteCharAt(stack.length() - 1);
            removeCount++;
        }

        System.out.println(stack.toString());
    }
}

/* 
동작 과정 예시: "1924", K=2

1. '1' 추가 → stack: "1"
2. '9' 추가 전, '1' < '9'이므로 '1' 제거 → stack: "", removeCount: 1
   '9' 추가 → stack: "9"
3. '2' 추가 → stack: "92"  
4. '4' 추가 전, '2' < '4'이므로 '2' 제거 → stack: "9", removeCount: 2
   '4' 추가 → stack: "94"

결과: "94"
*/