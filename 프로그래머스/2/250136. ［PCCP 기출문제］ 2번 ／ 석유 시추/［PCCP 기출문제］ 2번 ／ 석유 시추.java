import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int rows, cols;
    static int[][] land;
    static boolean[][] visited;
    static Map<Integer, Integer> oilAmount;

    public int solution(int[][] land) {
        this.land = land;
        rows = land.length;
        cols = land[0].length;
        visited = new boolean[rows][cols];
        oilAmount = new HashMap<>();

        // 1. 석유 덩어리 찾기
        int groupId = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, groupId);
                    groupId++;
                }
            }
        }

        // 2. 각 열에서 얻을 수 있는 최대 석유량 계산
        int maxOil = 0;
        for (int j = 0; j < cols; j++) {
            Set<Integer> groups = new HashSet<>();
            for (int i = 0; i < rows; i++) {
                if (land[i][j] != 0) {
                    groups.add(land[i][j]);
                }
            }
            int totalOil = 0;
            for (int group : groups) {
                totalOil += oilAmount.get(group);
            }
            maxOil = Math.max(maxOil, totalOil);
        }

        return maxOil;
    }

    static void bfs(int x, int y, int groupId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        land[x][y] = groupId;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols 
                    && land[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    land[nx][ny] = groupId;
                }
            }
        }
        oilAmount.put(groupId, count);
    }
}