import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < K; i++) {
            int num = sc.nextInt();
            
            if (num == 0) {
                stack.pop(); // 가장 최근 수 제거
            } else {
                stack.push(num); // 수 추가
            }
        }
        
        // 스택에 남은 수들의 합 계산
        int sum = 0;
        for (int n : stack) {
            sum += n;
        }
        
        System.out.println(sum);
    }
}