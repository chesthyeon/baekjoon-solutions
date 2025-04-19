import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // 인접 리스트로 그래프 구현
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 양방향 그래프 구성
        for (int[] wire : wires) {
            int a = wire[0], b = wire[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int minDiff = Integer.MAX_VALUE;
        
        // 각 간선을 하나씩 제거해보며 차이 계산
        for (int[] wire : wires) {
            int a = wire[0], b = wire[1];
            
            // a와 b 사이의 연결 임시 제거
            graph[a].remove(Integer.valueOf(b));
            graph[b].remove(Integer.valueOf(a));
            
            // 두 전력망의 크기 차이 계산
            int count = countNodes(graph, 1, new boolean[n + 1]);
            int diff = Math.abs(count - (n - count));
            minDiff = Math.min(minDiff, diff);
            
            // 제거했던 연결 복구
            graph[a].add(b);
            graph[b].add(a);
        }
        
        return minDiff;
    }
    
    // DFS로 연결된 노드 수 계산
    private int countNodes(List<Integer>[] graph, int node, boolean[] visited) {
        visited[node] = true;
        int count = 1; // 현재 노드 포함
        
        for (int next : graph[node]) {
            if (!visited[next]) {
                count += countNodes(graph, next, visited);
            }
        }
        
        return count;
    }
}