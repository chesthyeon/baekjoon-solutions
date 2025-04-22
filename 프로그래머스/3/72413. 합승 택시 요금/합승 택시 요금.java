class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        // 그래프 초기화 (플로이드-워셜용)
        int[][] dist = new int[n+1][n+1];
        
        // 모든 경로를 무한대로 초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = i == j ? 0 : 20000001; // 최대 비용보다 큰 값
            }
        }
        
        // 주어진 경로 정보로 그래프 구성
        for (int[] fare : fares) {
            int u = fare[0];
            int v = fare[1];
            int cost = fare[2];
            dist[u][v] = cost;
            dist[v][u] = cost; // 양방향 그래프
        }
        
        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        
        // 최소 비용 계산
        int minCost = dist[s][a] + dist[s][b]; // 합승 안 하는 경우
        
        // 각 지점에서 합승을 끝내는 경우
        for (int i = 1; i <= n; i++) {
            int costViaNodI = dist[s][i] + dist[i][a] + dist[i][b];
            minCost = Math.min(minCost, costViaNodI);
        }
        
        return minCost;
    }
}