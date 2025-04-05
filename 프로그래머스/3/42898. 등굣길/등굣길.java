import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        final int MOD = 1_000_000_007;
        int[][] dp = new int[n + 1][m + 1];
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        dp[1][1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1 && j == 1 || dp[i][j] == -1) {
                    continue;
                }
                int fromUp = (dp[i-1][j] == -1) ? 0 : dp[i-1][j];
                int fromLeft = (dp[i][j-1] == -1) ? 0 : dp[i][j-1];
                dp[i][j] = (fromUp + fromLeft) % MOD;
            }

        }
        return dp[n][m];
    }
}