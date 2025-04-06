class Solution {
    public int solution(int n, int[][] results) {
        // 그래프 초기화: 1은 승리, -1은 패배, 0은 관계 미확정
        int[][] graph = new int[n + 1][n + 1];
        
        // 주어진 승패 결과 적용
        for (int[] edge : results) {
            graph[edge[0]][edge[1]] = 1;  // 승리
            graph[edge[1]][edge[0]] = -1; // 패배
        }
        
        // 플로이드-워셜 알고리즘 적용
        for (int k = 1; k <= n; k++) {        // 경유 노드
            for (int i = 1; i <= n; i++) {    // 출발 노드
                for (int j = 1; j <= n; j++) { // 도착 노드
                    // i가 k를 이기고, k가 j를 이기면, i는 j를 이김
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                    // i가 k에게 지고, k가 j에게 지면, i는 j에게 짐
                    if (graph[i][k] == -1 && graph[k][j] == -1) {
                        graph[i][j] = -1;
                        graph[j][i] = 1;
                    }
                }
            }
        }
        
        // 순위가 확정된 선수 카운트
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (i != j && graph[i][j] != 0) {
                    count++;
                }
            }
            // 자신을 제외한 모든 선수와의 관계가 확정되면 순위 확정
            if (count == n - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}