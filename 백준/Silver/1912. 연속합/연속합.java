import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 수열의 크기 입력
        int n = Integer.parseInt(br.readLine());
        
        // 수열 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // Kadane's Algorithm 적용
        int currentSum = arr[0];  // 현재까지의 연속합
        int maxSum = arr[0];      // 전체 최대 연속합
        
        for (int i = 1; i < n; i++) {
            // 현재 원소를 더했을 때와 현재 원소부터 새로 시작했을 때 중 큰 값 선택
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            // 최대값 갱신
            maxSum = Math.max(maxSum, currentSum);
        }
        
        // 결과 출력
        System.out.println(maxSum);
        
        br.close();
    }
}