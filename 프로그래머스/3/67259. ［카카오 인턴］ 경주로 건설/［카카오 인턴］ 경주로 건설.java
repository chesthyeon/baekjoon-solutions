import java.util.*;

class Solution {
    // 방향을 상수로 정의 (0: 우, 1: 하, 2: 좌, 3: 상)
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    
    public int solution(int[][] board) {
        int n = board.length;
        // [x][y][방향] 좌표에 도달하는 최소 비용
        int[][][] cost = new int[n][n][4];
        
        // 비용 배열 초기화
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < 4; k++)
                    cost[i][j][k] = Integer.MAX_VALUE;
        
        // 시작점 비용 초기화 (모든 방향 0원)
        for (int i = 0; i < 4; i++)
            cost[0][0][i] = 0;
        
        // BFS 탐색을 위한 큐
        Queue<int[]> queue = new LinkedList<>();
        // [x, y, 방향, 비용] 형태로 저장
        queue.add(new int[]{0, 0, -1, 0});
        
        int answer = Integer.MAX_VALUE;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dir = cur[2], curCost = cur[3];
            
            // 도착점에 도달했다면 최소 비용 갱신
            if (x == n-1 && y == n-1) {
                answer = Math.min(answer, curCost);
                continue;
            }
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 범위 밖이거나 벽이면 건너뜀
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1)
                    continue;
                
                // 비용 계산: 직선 100원, 코너 500원 추가
                int newCost = curCost + 100;
                if (dir != -1 && dir != i) // 방향이 바뀌면 코너 추가 비용
                    newCost += 500;
                
                // 비용이 더 작다면 갱신하고 큐에 추가
                if (newCost < cost[nx][ny][i]) {
                    cost[nx][ny][i] = newCost;
                    queue.add(new int[]{nx, ny, i, newCost});
                }
            }
        }
        
        return answer;
    }
}