import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};  // 상하좌우
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        map = new int[M][N];
        dp = new int[M][N];
        
        // 지도 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // DP 배열 초기화 (-1: 아직 계산 안됨)
        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        System.out.println(dfs(0, 0));
    }
    
    static int dfs(int x, int y) {
        // 목적지 도달
        if (x == M - 1 && y == N - 1) {
            return 1;
        }
        
        // 이미 계산된 경우
        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        
        dp[x][y] = 0;  // 경로 수 초기화
        
        // 4방향으로 이동
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 범위 체크 & 높이 체크
            if (nx >= 0 && nx < M && ny >= 0 && ny < N 
                && map[nx][ny] < map[x][y]) {
                dp[x][y] += dfs(nx, ny);
            }
        }
        
        return dp[x][y];
    }
}