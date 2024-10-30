import java.util.*;

class Solution {
    int[][] map;
    int[] dx = {0, 1, 0, -1};  // 상하좌우 이동을 위한 x좌표 변화값
    int[] dy = {1, 0, -1, 0};  // 상하좌우 이동을 위한 y좌표 변화값
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[101][101];  // 좌표를 2배로 확대한 맵
        
        // 직사각형 그리기 (테두리는 1, 내부는 2로 표시)
        for(int[] rect : rectangle) {
            for(int i = rect[0]*2; i <= rect[2]*2; i++) {
                for(int j = rect[1]*2; j <= rect[3]*2; j++) {
                    // 이미 내부가 채워져 있지 않은 경우에만
                    if(map[i][j] != 2) {
                        if(i == rect[0]*2 || i == rect[2]*2 || j == rect[1]*2 || j == rect[3]*2) {
                            if(map[i][j] != 2) map[i][j] = 1;
                        } else {
                            map[i][j] = 2;
                        }
                    }
                }
            }
        }
        
        return bfs(characterX*2, characterY*2, itemX*2, itemY*2) / 2;
    }
    
    // BFS로 최단 경로 찾기
    private int bfs(int startX, int startY, int targetX, int targetY) {
        boolean[][] visited = new boolean[101][101];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY, 0});  // x, y, distance
        visited[startX][startY] = true;
        
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];
            
            if(x == targetX && y == targetY) {
                return distance;
            }
            
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx >= 0 && nx <= 100 && ny >= 0 && ny <= 100 
                   && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, distance + 1});
                }
            }
        }
        
        return -1;
    }
}