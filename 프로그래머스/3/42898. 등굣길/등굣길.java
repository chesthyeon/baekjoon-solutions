class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1_000_000_007;
        
        // DP 배열 생성
        int[][] dp = new int[n+1][m+1];
        
        // 웅덩이 표시 (-1로 표시)
        for (int[] puddle : puddles) {
            dp[puddle[1]][puddle[0]] = -1;
        }
        
        // 시작점 값 설정
        dp[1][1] = 1;
        
        // 모든 칸을 순회하며 경로의 수 계산
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 시작점이거나 웅덩이면 건너뛰기
                if ((i == 1 && j == 1) || dp[i][j] == -1) {
                    continue;
                }
                
                // 위쪽에서 오는 경로의 수
                int fromUp = (dp[i-1][j] == -1) ? 0 : dp[i-1][j];
                
                // 왼쪽에서 오는 경로의 수
                int fromLeft = (dp[i][j-1] == -1) ? 0 : dp[i][j-1];
                
                // 현재 위치까지의 경로 수 계산
                dp[i][j] = (fromUp + fromLeft) % MOD;
            }
        }
        
        return dp[n][m];
    }
}