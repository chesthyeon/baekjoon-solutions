import java.util.*;

class Solution {
    int[] dx = new int[]{0,-1,0,1};
    int[] dy = new int[]{-1,0,1,0};
    public int solution(String[] maps) {
        int h = maps.length;
        int w = maps[0].length();

        int[] start = new int[2], end = new int[2], lever =  new int[2];

        char[][] maze = new char[h][w];
        for (int i = 0; i < maze.length; i++) {
            maze[i] = maps[i].toCharArray();
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (maze[i][j] == 'E') {
                    end[0] = i;
                    end[1] = j;
                } else if (maze[i][j] == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                }
            }
        }

        int dist1 = bfs(maze, start, lever, h, w);
        if (dist1 == -1) {return -1;}

        int dist2 =  bfs(maze, lever, end, h, w);
        if (dist2 == -1) {return -1;}

        return dist1 + dist2;
    }

    int bfs(char[][] maze, int[] start, int[] end, int h, int w) {
        int[][] dist = new int[h][w];
        dist[start[0]][start[1]] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            if (x == end[0] && y == end[1]) {
                return dist[x][y] - 1;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < h && ny < w && maze[nx][ny] != 'X' && dist[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    dist[nx][ny] = dist[x][y] + 1;
                }
            }
        }
        return -1;
    }
}