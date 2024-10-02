import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[5001];  // N의 최대값이 5000이므로
        
        // 초기값 설정
        dp[3] = dp[5] = 1;
        
        // DP 테이블 채우기
        for (int i = 6; i <= N; i++) {
            if (dp[i-3] != 0) {
                dp[i] = dp[i-3] + 1;
            }
            
            if (dp[i-5] != 0) {
                if (dp[i] == 0) {
                    dp[i] = dp[i-5] + 1;
                } else {
                    dp[i] = Math.min(dp[i], dp[i-5] + 1);
                }
            }
        }
        
        // 결과 출력
        System.out.println(dp[N] == 0 ? -1 : dp[N]);
    }
}