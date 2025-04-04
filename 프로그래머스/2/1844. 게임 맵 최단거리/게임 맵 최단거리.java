import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 상하좌우 이동을 위한 방향 배열
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int rows = maps.length;
        int cols = maps[0].length;
        
        // 방문 여부와 거리를 함께 저장
        int[][] distances = new int[rows][cols];
        
        return bfs(maps, distances, rows, cols);
    }
    
    private int bfs(int[][] maps, int[][] distances, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        
        // 시작점 설정
        queue.offer(new int[]{0, 0});
        distances[0][0] = 1; // 시작 위치도 카운트에 포함
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int currentDist = distances[x][y];
            
            // 목적지에 도달한 경우
            if (x == rows - 1 && y == cols - 1) {
                return currentDist;
            }
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 맵 범위 체크 및 갈 수 있는 길인지 체크
                if (isValidPosition(nx, ny, rows, cols) && maps[nx][ny] == 1 && distances[nx][ny] == 0) {
                    distances[nx][ny] = currentDist + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        
        // 목적지에 도달할 수 없는 경우
        return -1;
    }
    
    private boolean isValidPosition(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}