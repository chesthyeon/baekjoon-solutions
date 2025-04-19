import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 그래프 구성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // BFS
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[1] = 0;

        int maxDist = 0;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int next : graph.get(curr)) {
                if (dist[next] == -1) {
                    dist[next] = dist[curr] + 1;
                    queue.add(next);
                    maxDist = Math.max(maxDist, dist[next]);
                }
            }
        }

        // 가장 먼 노드 개수 계산
        int count = 0;
        for (int d : dist) {
            if (d == maxDist) count++;
        }

        return count;
    }
}