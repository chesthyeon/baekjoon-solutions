import java.util.*;

class Solution {
    int[] dx = new int[]{-1, 0, 1, 0};
    int[] dy = new int[]{0, 1, 0, -1};

    public int solution(int[][] maps) {
        int rows = maps.length;
        int cols = maps[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});

        // 시작점을 2로 표시하여 방문했음을 나타내고, 시작점의 거리를 2로 설정 (1은 이동 가능한 칸)
        maps[0][0] = 2;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];

            // 도착점에 도달했는지 확인
            if (x == rows - 1 && y == cols - 1) {
                return maps[x][y] - 1;  // 실제 거리는 맵 값에서 1을 뺀 값
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                // 경계 체크, 이동 가능한 칸 체크 (값이 1인 경우만)
                if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && maps[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    maps[nx][ny] = maps[x][y] + 1;  // 이전 칸의 거리 + 1
                }
            }
        }

        return -1;  // 도착점에 도달할 수 없는 경우
    }
}