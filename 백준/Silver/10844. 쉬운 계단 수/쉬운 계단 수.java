import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        final int MOD = 1000000000;
        
        // dp[i][j] = 길이가 i이고 마지막 자리가 j인 계단 수의 개수
        long[][] dp = new long[N + 1][10];
        
        // 초기값: 길이가 1인 경우 (0으로 시작 불가)
        for (int j = 1; j <= 9; j++) {
            dp[1][j] = 1;
        }
        
        // DP 진행
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                // 이전 자리가 j-1이었던 경우
                if (j > 0) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-1]) % MOD;
                }
                // 이전 자리가 j+1이었던 경우
                if (j < 9) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j+1]) % MOD;
                }
            }
        }
        
        // 답 계산: 길이 N인 모든 계단 수의 합
        long answer = 0;
        for (int j = 0; j <= 9; j++) {
            answer = (answer + dp[N][j]) % MOD;
        }
        
        System.out.println(answer);
    }
}

/*
시간복잡도: O(N × 10) = O(N)
공간복잡도: O(N × 10) = O(N)

메모리 최적화 가능:
이전 행의 정보만 필요하므로 1차원 배열로도 가능
*/