import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 포도주 양 저장 (1-indexed)
        int[] wine = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        
        // dp[i] = i번째 잔까지 고려했을 때 최대 포도주 양
        int[] dp = new int[n + 1];
        
        // 초기값 설정
        if (n >= 1) dp[1] = wine[1];
        if (n >= 2) dp[2] = wine[1] + wine[2];
        
        // DP 계산
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(
                Math.max(
                    dp[i - 1],                           // 현재 잔 안 마시기
                    dp[i - 2] + wine[i]                  // 현재만 마시기 (이전 잔 건너뛰기)
                ),
                dp[i - 3] + wine[i - 1] + wine[i]       // 연속 2잔 마시기 (i-1, i)
            );
        }
        
        System.out.println(dp[n]);
    }
}