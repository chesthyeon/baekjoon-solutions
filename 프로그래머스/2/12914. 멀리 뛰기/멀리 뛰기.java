class Solution {

    public long solution(int n) {
        if (n <= 2) return n; // 예외 케이스: 1칸 → 1, 2칸 → 2

        long[] dp = new long[n + 1];
        dp[1] = 1L;
        dp[2] = 2L;

        // 점화식 적용: dp[i] = dp[i-1] + dp[i-2]
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }

}