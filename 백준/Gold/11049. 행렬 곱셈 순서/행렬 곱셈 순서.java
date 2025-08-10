import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] p;  // 행렬 차원 배열 (p[i-1] x p[i] 크기의 i번째 행렬)
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        p = new int[N + 1];
        dp = new int[N + 1][N + 1];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if (i == 0) {
                p[0] = r;
            }
            p[i + 1] = c;
        }
        
        System.out.println(matrixChainOrder());
    }
    
    static int matrixChainOrder() {
        for (int len = 2; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i - 1] * p[k] * p[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        
        return dp[1][N];
    }
}