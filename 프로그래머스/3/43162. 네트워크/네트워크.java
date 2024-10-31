import java.util.*;

class Solution {
    boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(n, computers, i);
                answer++;
            }
        }
        return answer;
    }
    private void bfs(int n, int[][] computers, int idx){
        Queue<int[]> q = new LinkedList<>();
        q.add(computers[idx]);
        visited[idx] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < cur.length; i++) {
                if (cur[i] == 0) {
                    continue;
                }
                int nexIdx = i;
                if (!visited[nexIdx]){
                    q.add(computers[nexIdx]);
                    visited[nexIdx] = true;
                }
            }
        }
    }
}