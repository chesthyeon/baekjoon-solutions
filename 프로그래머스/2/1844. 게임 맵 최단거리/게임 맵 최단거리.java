import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length, m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        
        // 상하좌우 방향
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // {x, y, 거리}
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];
            
            // 목표 도달
            if (x == n-1 && y == m-1) return dist;
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && 
                    maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        
        return -1; // 도달 불가능
    }
}