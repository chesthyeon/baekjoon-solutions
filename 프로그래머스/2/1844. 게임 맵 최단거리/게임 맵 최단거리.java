import java.util.ArrayDeque;

class Solution {
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, -1, 0, 1};

    public int solution(int[][] maps) {
        int rows = maps.length;
        int cols = maps[0].length;
        int[][] distances = new int[rows][cols];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        distances[0][0] = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            if (x == rows - 1 && y == cols - 1) {
                return distances[x][y];
            }
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && maps[nx][ny] == 1 && distances[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    distances[nx][ny] = distances[x][y] + 1;
                }
            }
        }
        return -1;
    }
}