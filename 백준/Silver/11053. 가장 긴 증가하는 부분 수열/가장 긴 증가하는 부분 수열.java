import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // DP 진행
        for (int i = 0; i < N; i++) {
            dp[i] = 1; // 자기 자신만으로도 길이 1

            // i번째 원소보다 작은 이전 원소들 확인
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 최댓값 찾기
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}

/*
동작 과정 예시: [10, 20, 10, 30, 20, 50]

인덱스: 0   1   2   3   4   5
수열:  10  20  10  30  20  50
dp:    1   2   1   3   2   4

i=0: dp[0] = 1 (10만)
i=1: dp[1] = dp[0] + 1 = 2 (10 < 20이므로)
i=2: dp[2] = 1 (10보다 작은 이전 원소 없음)
i=3: dp[3] = max(dp[0]+1, dp[1]+1, dp[2]+1) = 3 (20 < 30이므로 dp[1]+1)
i=4: dp[4] = dp[0] + 1 = 2 (10 < 20이므로)
i=5: dp[5] = max(dp[0]+1, dp[1]+1, dp[3]+1, dp[4]+1) = 4

결과: 4
*/