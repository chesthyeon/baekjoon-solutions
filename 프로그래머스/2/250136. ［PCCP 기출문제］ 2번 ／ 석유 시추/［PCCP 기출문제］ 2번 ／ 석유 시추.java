import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int rows, cols;
    
    public int solution(int[][] land) {
        rows = land.length;
        cols = land[0].length;
        int[][] visited = new int[rows][cols];
        Map<Integer, Integer> oilAmounts = new HashMap<>();
        int groupId = 1;
        
        // 연결된 석유 구역 찾기
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (land[i][j] == 1 && visited[i][j] == 0) {
                    int amount = bfs(land, visited, i, j, groupId);
                    oilAmounts.put(groupId, amount);
                    groupId++;
                }
            }
        }
        
        // 각 열에서 얻을 수 있는 석유량 계산
        int maxOil = 0;
        for (int j = 0; j < cols; j++) {
            Set<Integer> groups = new HashSet<>();
            for (int i = 0; i < rows; i++) {
                if (visited[i][j] != 0) {
                    groups.add(visited[i][j]);
                }
            }
            int totalOil = groups.stream().mapToInt(g -> oilAmounts.get(g)).sum();
            maxOil = Math.max(maxOil, totalOil);
        }
        
        return maxOil;
    }
    
    private int bfs(int[][] land, int[][] visited, int x, int y, int groupId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = groupId;
        int amount = 0;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            amount++;
            
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols 
                    && land[nx][ny] == 1 && visited[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = groupId;
                }
            }
        }
        
        return amount;
    }
}