import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        // 1. 인접 리스트 구성
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            graph[r[0]].add(new int[]{r[1], r[2]}); // {목적지, 비용}
            graph[r[1]].add(new int[]{r[0], r[2]});
        }
        
        // 2. 다익스트라
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{1, 0}); // {노드, 거리}
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], cost = cur[1];
            
            if (cost > dist[node]) continue;
            
            for (int[] next : graph[node]) {
                int nextNode = next[0], nextCost = next[1];
                int newDist = cost + nextCost;
                
                if (newDist < dist[nextNode]) {
                    dist[nextNode] = newDist;
                    pq.offer(new int[]{nextNode, newDist});
                }
            }
        }
        
        // 3. K 이하인 마을 개수 세기
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
}