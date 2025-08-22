import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] temp;
    static int maxSafeArea = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<int[]> emptySpaces = new ArrayList<>();
    static List<int[]> viruses = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        temp = new int[N][M];
        
        // 입력 받으면서 빈 공간과 바이러스 위치 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    emptySpaces.add(new int[]{i, j});
                } else if (map[i][j] == 2) {
                    viruses.add(new int[]{i, j});
                }
            }
        }
        
        // 벽 3개 세우기 (백트래킹)
        buildWalls(0, 0);
        
        System.out.println(maxSafeArea);
    }
    
    // 벽 3개를 세우는 모든 경우의 수 탐색
    static void buildWalls(int count, int start) {
        if (count == 3) {
            // 벽 3개를 다 세웠으면 바이러스 확산 시뮬레이션
            simulate();
            return;
        }
        
        // 빈 공간 중에서 벽을 세울 곳 선택
        for (int i = start; i < emptySpaces.size(); i++) {
            int[] pos = emptySpaces.get(i);
            int x = pos[0], y = pos[1];
            
            map[x][y] = 1;  // 벽 설치
            buildWalls(count + 1, i + 1);
            map[x][y] = 0;  // 백트래킹 (벽 제거)
        }
    }
    
    // 바이러스 확산 시뮬레이션
    static void simulate() {
        // 현재 상태를 temp에 복사
        for (int i = 0; i < N; i++) {
            temp[i] = map[i].clone();
        }
        
        // BFS로 바이러스 확산
        Queue<int[]> queue = new LinkedList<>();
        for (int[] virus : viruses) {
            queue.offer(new int[]{virus[0], virus[1]});
        }
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M 
                    && temp[nx][ny] == 0) {
                    temp[nx][ny] = 2;  // 바이러스 확산
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        
        // 안전 영역 개수 계산
        int safeArea = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) {
                    safeArea++;
                }
            }
        }
        
        maxSafeArea = Math.max(maxSafeArea, safeArea);
    }
}