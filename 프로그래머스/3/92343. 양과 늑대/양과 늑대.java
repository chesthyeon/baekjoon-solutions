import java.util.*;

public class Solution {
    private static ArrayList<Integer>[] tree;
    
    public int solution(int[] info, int[][] edges) {
        // 트리 구축
        tree = new ArrayList[info.length];
        for (int i = 0; i < info.length; i++) tree[i] = new ArrayList<>();
        for (int[] edge : edges) tree[edge[0]].add(edge[1]);
        
        // BFS 수행
        int maxSheep = 0;
        Queue<int[]> q = new LinkedList<>();
        Queue<HashSet<Integer>> nextNodes = new LinkedList<>();
        
        // 시작 상태: [노드, 양, 늑대]
        q.add(new int[]{0, 1, 0});
        nextNodes.add(new HashSet<>());
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            HashSet<Integer> next = nextNodes.poll();
            
            int node = cur[0], sheep = cur[1], wolf = cur[2];
            maxSheep = Math.max(maxSheep, sheep);
            
            // 다음 방문 가능한 노드 목록 업데이트
            next.addAll(tree[node]);
            
            // 방문 가능한 모든 노드 탐색
            for (int nextNode : next) {
                HashSet<Integer> newNext = new HashSet<>(next);
                newNext.remove(nextNode);
                
                if (info[nextNode] == 0) { // 양인 경우
                    q.add(new int[]{nextNode, sheep + 1, wolf});
                    nextNodes.add(newNext);
                } else if (sheep > wolf + 1) { // 늑대인 경우, 양이 더 많을 때만
                    q.add(new int[]{nextNode, sheep, wolf + 1});
                    nextNodes.add(newNext);
                }
            }
        }
        
        return maxSheep;
    }
}