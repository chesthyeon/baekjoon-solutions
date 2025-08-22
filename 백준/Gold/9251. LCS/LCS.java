import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str1 = br.readLine();
        String str2 = br.readLine();
        
        int len1 = str1.length();
        int len2 = str2.length();
        
        // DP 테이블 (1-indexed로 사용)
        int[][] dp = new int[len1 + 1][len2 + 1];
        
        // DP 계산
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    // 문자가 같으면 대각선 값 + 1
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    // 문자가 다르면 위쪽, 왼쪽 중 최대값
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        System.out.println(dp[len1][len2]);
    }
}