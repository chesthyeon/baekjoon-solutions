import java.util.*;

class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    int rows, cols;
    int gasId = 2;
    int[][] land;
    boolean[][] visited;
    public int solution(int[][] land) {
        int answer = 0;
        this.land = land;
        this.rows = land.length;
        this.cols = land[0].length;
        visited = new boolean[rows][cols];
        Map<Integer, Integer> gasMap = new HashMap<>();
        for (int i = 0; i < rows; i ++){
            for (int j = 0; j < cols; j++){
                if (land[i][j] == 1 && !visited[i][j]){
                    gasMap.put(gasId, bfs(i, j));
                    gasId++;
                }
            }
        }

        for (int col = 0; col < cols; col++){
            Set<Integer> gasIds = new HashSet<>();
            int totalGas = 0;
            for (int row = 0; row < rows; row++){
                if (land[row][col] > 1){
                    gasIds.add(land[row][col]);
                }
            }
            for (int gas : gasIds){
                totalGas += gasMap.get(gas);
            }
            answer = Math.max(answer,totalGas);
        }
        return answer;
    }
    public int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        visited[x][y] = true;  // 추가: 시작점 방문 표시
        land[x][y] = gasId;
        int totalGas = 0;
        while (!queue.isEmpty()){
            int cur[] = queue.poll();
            totalGas++;
            for (int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols
                        && land[nx][ny] == 1 && !visited[nx][ny]){
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    land[nx][ny] = gasId;
                }
            }
        }
        return totalGas;
    }
}