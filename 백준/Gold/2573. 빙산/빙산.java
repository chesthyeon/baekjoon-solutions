import java.util.*;

public class Main {
    static int N, M;
    static int[][] iceberg;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};  // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        iceberg = new int[N][M];
        
        // 빙산 정보 입력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                iceberg[i][j] = sc.nextInt();
            }
        }
        
        int year = 0;
        
        while (true) {
            // 1. 현재 빙산 덩어리 개수 확인
            int icebergCount = countIcebergGroups();
            
            // 빙산이 모두 녹았다면 0 출력
            if (icebergCount == 0) {
                System.out.println(0);
                return;
            }
            
            // 빙산이 2개 이상으로 분리되었다면 현재 년도 출력
            if (icebergCount >= 2) {
                System.out.println(year);
                return;
            }
            
            // 2. 1년 경과 - 빙산 녹이기
            meltIceberg();
            year++;
        }
    }
    
    // 빙산 덩어리 개수를 세는 함수 (DFS 사용)
    static int countIcebergGroups() {
        visited = new boolean[N][M];
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 빙산이 있고 아직 방문하지 않았다면
                if (iceberg[i][j] > 0 && !visited[i][j]) {
                    dfs(i, j);  // 연결된 빙산들을 모두 방문 처리
                    count++;    // 덩어리 개수 증가
                }
            }
        }
        
        return count;
    }
    
    // DFS로 연결된 빙산들을 모두 방문 처리
    static void dfs(int x, int y) {
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 경계 체크 & 빙산이 있고 방문하지 않았다면
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (iceberg[nx][ny] > 0 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
    
    // 빙산을 1년만큼 녹이는 함수
    static void meltIceberg() {
        int[][] meltAmount = new int[N][M];  // 각 칸에서 녹을 양을 저장
        
        // 1단계: 각 빙산 칸에서 인접한 바다의 개수 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceberg[i][j] > 0) {  // 빙산이 있는 칸이라면
                    int seaCount = 0;
                    
                    // 상하좌우 확인
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        
                        // 경계 내에 있고 바다(0)라면
                        if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                            if (iceberg[nx][ny] == 0) {
                                seaCount++;
                            }
                        }
                    }
                    
                    meltAmount[i][j] = seaCount;
                }
            }
        }
        
        // 2단계: 계산된 양만큼 빙산 녹이기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (iceberg[i][j] > 0) {
                    iceberg[i][j] -= meltAmount[i][j];
                    
                    // 0 이하로 내려가지 않도록 처리
                    if (iceberg[i][j] < 0) {
                        iceberg[i][j] = 0;
                    }
                }
            }
        }
    }
}