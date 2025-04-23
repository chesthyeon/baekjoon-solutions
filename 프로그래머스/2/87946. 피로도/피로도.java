public class Solution {
    public int solution(int k, int[][] dungeons) {
        // 방문 여부를 체크할 배열
        boolean[] visited = new boolean[dungeons.length];
        
        // 최대 던전 수를 찾는 백트래킹 함수 호출
        return findMaxDungeons(k, dungeons, visited, 0);
    }
    
    // 재귀적으로 최대 던전 수를 찾는 함수
    private int findMaxDungeons(int fatigue, int[][] dungeons, boolean[] visited, int count) {
        // 현재까지 방문한 던전 수
        int maxCount = count;
        
        // 모든 던전을 확인
        for (int i = 0; i < dungeons.length; i++) {
            // 아직 방문하지 않았고, 피로도가 충분하다면
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                // 방문 표시
                visited[i] = true;
                
                // 던전 탐험 후 남은 피로도로 다음 던전 탐색
                // 현재까지의 최대값과 비교하여 더 큰 값 선택
                int newCount = findMaxDungeons(
                    fatigue - dungeons[i][1], 
                    dungeons, 
                    visited, 
                    count + 1
                );
                maxCount = Math.max(maxCount, newCount);
                
                // 방문 표시 취소 (백트래킹)
                visited[i] = false;
            }
        }
        
        return maxCount;
    }
}