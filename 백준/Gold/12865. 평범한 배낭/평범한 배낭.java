import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 물건 개수
        int K = Integer.parseInt(st.nextToken()); // 배낭 용량
        
        int[] weight = new int[N + 1]; // 무게
        int[] value = new int[N + 1];  // 가치
        
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }
        
        // DP 테이블: dp[i][w] = i번째 물건까지 고려했을 때 무게 w 이하의 최대 가치
        int[][] dp = new int[N + 1][K + 1];
        
        // DP 진행
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                // 현재 물건을 넣지 않는 경우
                dp[i][w] = dp[i-1][w];
                
                // 현재 물건을 넣을 수 있고, 넣는 것이 더 유리한 경우
                if (weight[i] <= w) {
                    dp[i][w] = Math.max(dp[i][w], dp[i-1][w-weight[i]] + value[i]);
                }
            }
        }
        
        System.out.println(dp[N][K]);
    }
}

/*
DP 테이블 진행 과정 예시:
물건: [(무게6,가치13), (무게4,가치8), (무게3,가치6), (무게5,가치12)]
배낭 용량: 7

     w=0  w=1  w=2  w=3  w=4  w=5  w=6  w=7
i=0   0    0    0    0    0    0    0    0
i=1   0    0    0    0    0    0   13   13   (물건1: 무게6)
i=2   0    0    0    0    8    8   13   13   (물건2: 무게4)
i=3   0    0    0    6    8    8   13   14   (물건3: 무게3, 4+3=7에서 8+6=14)
i=4   0    0    0    6    8   12   13   14   (물건4: 무게5)

답: dp[4][7] = 14
*/