import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 상하좌우 이동
    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {-1, 1, 0, 0};
    
    public int solution(String[] maps) {
        int h = maps.length;
        int w = maps[0].length();
        char[][] maze = new char[h][w];
        
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];
        
        // 맵 변환 및 위치 찾기
        for (int i = 0; i < h; i++) {
            maze[i] = maps[i].toCharArray();
            for (int j = 0; j < w; j++) {
                if (maze[i][j] == 'S') { start[0] = i; start[1] = j; }
                else if (maze[i][j] == 'L') { lever[0] = i; lever[1] = j; }
                else if (maze[i][j] == 'E') { exit[0] = i; exit[1] = j; }
            }
        }
        
        // 시작->레버, 레버->출구 최단거리 계산
        int dist1 = bfs(maze, start, lever, h, w);
        if (dist1 == -1) return -1;
        
        int dist2 = bfs(maze, lever, exit, h, w);
        if (dist2 == -1) return -1;
        
        return dist1 + dist2;
    }
    
    private int bfs(char[][] maze, int[] start, int[] end, int h, int w) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[h][w];
        
        q.offer(new int[]{start[0], start[1]});
        dist[start[0]][start[1]] = 1;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];
            
            if (y == end[0] && x == end[1]) 
                return dist[y][x] - 1;
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny >= 0 && ny < h && nx >= 0 && nx < w && 
                    maze[ny][nx] != 'X' && dist[ny][nx] == 0) {
                    q.offer(new int[]{ny, nx});
                    dist[ny][nx] = dist[y][x] + 1;
                }
            }
        }
        return -1;
    }
}