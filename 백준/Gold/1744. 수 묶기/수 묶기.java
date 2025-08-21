import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        List<Integer> positive = new ArrayList<>(); // 양수 (2 이상)
        List<Integer> negative = new ArrayList<>(); // 음수
        int ones = 0; // 1의 개수
        int zeros = 0; // 0의 개수
        
        // 수들을 분류
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (num > 1) {
                positive.add(num);
            } else if (num == 1) {
                ones++;
            } else if (num == 0) {
                zeros++;
            } else {
                negative.add(num);
            }
        }
        
        // 정렬
        Collections.sort(positive, Collections.reverseOrder()); // 내림차순
        Collections.sort(negative); // 오름차순 (절댓값이 큰 순)
        
        int result = 0;
        
        // 양수 처리 (큰 수끼리 묶기)
        for (int i = 0; i < positive.size(); i += 2) {
            if (i + 1 < positive.size()) {
                // 두 개씩 묶어서 곱하기
                result += positive.get(i) * positive.get(i + 1);
            } else {
                // 하나 남으면 그냥 더하기
                result += positive.get(i);
            }
        }
        
        // 음수 처리 (절댓값 큰 것끼리 묶기)
        for (int i = 0; i < negative.size(); i += 2) {
            if (i + 1 < negative.size()) {
                // 두 개씩 묶어서 곱하기
                result += negative.get(i) * negative.get(i + 1);
            } else {
                // 하나 남으면
                if (zeros > 0) {
                    // 0과 곱해서 제거 (0을 더함)
                } else {
                    // 0이 없으면 그냥 더하기
                    result += negative.get(i);
                }
            }
        }
        
        // 1들은 모두 더하기
        result += ones;
        
        System.out.println(result);
    }
}