import java.util.Arrays;

class Solution {
    // 각 노드의 부모를 저장하는 배열
    private int[] parent;
    
    // 노드가 속한 집합의 루트 노드 찾기
    private int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        // 경로 압축: 재귀적으로 루트를 찾으며 parent 값을 루트로 업데이트
        return parent[node] = find(parent[node]);
    }
    
    // 두 노드가 속한 집합 합치기
    private void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);
        
        // 이미 같은 집합이면 수행하지 않음
        if (root1 != root2) {
            parent[root2] = root1;
        }
    }
    
    public int solution(int n, int[][] costs) {
        // 간선을 비용 기준으로 오름차순 정렬
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        // 부모 배열 초기화: 처음에는 자기 자신이 부모
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int totalCost = 0;
        int connectedBridges = 0;
        
        // 모든 간선을 비용이 적은 순서대로 확인
        for (int[] cost : costs) {
            int island1 = cost[0];
            int island2 = cost[1];
            int bridgeCost = cost[2];
            
            // 두 섬이 아직 연결되지 않았다면
            if (find(island1) != find(island2)) {
                union(island1, island2);  // 두 섬 연결
                totalCost += bridgeCost;  // 비용 추가
                connectedBridges++;       // 연결된 다리 수 증가
                
                // MST 완성: n개의 섬을 연결하는데 필요한 다리는 n-1개
                if (connectedBridges == n - 1) {
                    break;
                }
            }
        }
        
        return totalCost;
    }
}