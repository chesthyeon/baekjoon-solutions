import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 그래프 초기화
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 양방향 그래프 구성
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // BFS를 위한 준비
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);  // 방문하지 않은 노드는 -1

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);  // 1번 노드부터 시작
        distances[1] = 0;

        int maxDistance = 0;

        // BFS 실행
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (distances[next] == -1) {  // 아직 방문하지 않은 노드
                    distances[next] = distances[current] + 1;
                    queue.offer(next);
                    maxDistance = Math.max(maxDistance, distances[next]);
                }
            }
        }

        // 가장 먼 노드 개수 계산
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == maxDistance) {
                count++;
            }
        }

        return count;
    }
}