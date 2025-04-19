class Solution {
    public int solution(int n, int[][] results) {
        // 승패 관계를 저장할 그래프
        boolean[][] wins = new boolean[n+1][n+1];
        
        // 주어진 결과로 그래프 초기화
        for (int[] result : results) {
            wins[result[0]][result[1]] = true;
        }
        
        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= n; k++) {       // 경유 선수
            for (int i = 1; i <= n; i++) {   // 시작 선수
                for (int j = 1; j <= n; j++) { // 도착 선수
                    // i가 k를 이기고, k가 j를 이겼다면, i는 j를 이긴다
                    if (wins[i][k] && wins[k][j]) {
                        wins[i][j] = true;
                    }
                }
            }
        }
        
        // 순위를 확정할 수 있는 선수 카운트
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            
            for (int j = 1; j <= n; j++) {
                if (i == j) continue; // 자기 자신은 건너뛰기
                
                // i가 j를 이기거나, j가 i를 이기면 관계가 확정됨
                if (wins[i][j] || wins[j][i]) {
                    count++;
                }
            }
            
            // 모든 다른 선수와의 관계가 확정되면 순위 확정 가능
            if (count == n-1) {
                answer++;
            }
        }
        
        return answer;
    }
}