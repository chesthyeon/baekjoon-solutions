import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 원본 배열 (1-indexed)
        int[][] arr = new int[N + 1][N + 1];
        
        // 누적 합 배열
        int[][] prefix = new int[N + 1][N + 1];
        
        // 입력 받으면서 누적 합 계산
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                
                // 누적 합 계산
                prefix[i][j] = prefix[i-1][j] + prefix[i][j-1] 
                             - prefix[i-1][j-1] + arr[i][j];
            }
        }
        
        // 쿼리 처리
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            
            // 구간 합 계산
            int result = prefix[x2][y2] - prefix[x1-1][y2] 
                       - prefix[x2][y1-1] + prefix[x1-1][y1-1];
            
            sb.append(result).append('\n');
        }
        
        System.out.print(sb);
    }
}