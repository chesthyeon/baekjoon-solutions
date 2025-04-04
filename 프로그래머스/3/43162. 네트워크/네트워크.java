class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                cnt++;
            }
        }
        return cnt;
    }
    void dfs(int i, boolean[] visited,  int[][] computers) {
        visited[i] = true;
        for (int j = 0; j < computers[i].length; j++) {
            if (computers[i][j] == 1 && !visited[j]) {
                dfs(j, visited, computers);
            }
        }
    }
}