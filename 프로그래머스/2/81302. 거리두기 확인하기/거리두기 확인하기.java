import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        // 상, 하, 좌, 우 이동을 위한 배열
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int room = 0; room < 5; room++) {
            String[] place = places[room];
            boolean isViolated = false;
            
            // 각 위치를 검사
            for (int i = 0; i < 5 && !isViolated; i++) {
                for (int j = 0; j < 5 && !isViolated; j++) {
                    // 사람이 있는 위치에서 시작
                    if (place[i].charAt(j) == 'P') {
                        isViolated = !checkDistance(place, i, j, dx, dy);
                    }
                }
            }
            
            answer[room] = isViolated ? 0 : 1;
        }
        
        return answer;
    }
    
    private boolean checkDistance(String[] place, int x, int y, int[] dx, int[] dy) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5]; // 방문 체크를 위한 배열
        
        queue.offer(new int[]{x, y, 0}); // 위치 x, y와 현재까지의 거리
        visited[x][y] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            int distance = current[2];
            
            // 맨해튼 거리가 이미 2를 초과하면 더 이상 확인할 필요 없음
            if (distance > 2) continue;
            
            // 시작점이 아니고, 사람이 있고, 거리가 2 이하면 거리두기 위반
            if (!(cx == x && cy == y) && place[cx].charAt(cy) == 'P' && distance <= 2) {
                return false;
            }
            
            // 상하좌우 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                // 범위를 벗어나면 건너뜀
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
                // 이미 방문했거나 파티션이면 건너뜀
                if (visited[nx][ny] || place[nx].charAt(ny) == 'X') continue;
                
                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, distance + 1});
            }
        }
        
        // 모든 탐색을 마쳤으나 위반 사항이 없으면 거리두기 준수
        return true;
    }
}