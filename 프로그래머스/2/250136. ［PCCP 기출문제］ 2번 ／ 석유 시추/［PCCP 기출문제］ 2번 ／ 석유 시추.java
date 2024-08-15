import java.util.*;

class Solution {
    static int[] dx = new int[]{-1, 1, 0, 0};  // 수정: -0을 0으로 변경
    static int[] dy = new int[]{0, 0, -1, 1};
    static int[][] land;
    static int rows, cols;
    static boolean[][] visited;
    static Map<Integer, Integer> oilAmount;

    public int solution(int[][] land) {
        this.land = land;
        rows = land.length;
        cols = land[0].length;
        visited = new boolean[rows][cols];
        oilAmount = new HashMap<>();

        // 1. 석유 덩어리 찾기
        int groupId = 2;  // 수정: 1 대신 2부터 시작
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (land[i][j] == 1 && !visited[i][j]) {  // 조건 추가
                    bfs(i, j, groupId);
                    groupId++;
                }
            }
        }

        // 각 열에서 최대 얻을 수 있는 석유량 계산
        int answer = 0;
        for (int j = 0; j < cols; j++){
            Set<Integer> groups = new HashSet<>();
            for (int i = 0; i < rows; i++){
                if (land[i][j] > 1){  // 수정: 0이 아닌 경우 대신 1보다 큰 경우
                    groups.add(land[i][j]);
                }
            }
            int totalOil = 0;
            for (int group : groups){
                totalOil += oilAmount.get(group);
            }
            answer = Math.max(answer, totalOil);
        }
        return answer;
    }

    static void bfs(int x, int y, int groupId){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;  // 추가: 시작점 방문 표시
        land[x][y] = groupId;
        int count = 0;

        while (!queue.isEmpty()){  // 수정: isEmpty()를 !isEmpty()로 변경
            int[] cur = queue.poll();
            count++;
            for (int i = 0; i < 4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols
                    && land[nx][ny] == 1 && !visited[nx][ny]){
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    land[nx][ny] = groupId;
                }
            }
        }
        oilAmount.put(groupId, count);
    }
}