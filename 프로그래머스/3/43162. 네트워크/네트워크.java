class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int networkCount = 0;
        
        // 모든 컴퓨터를 확인
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // 새로운 네트워크 발견
                dfs(i, computers, visited);
                networkCount++;
            }
        }
        
        return networkCount;
    }
    
    void dfs(int computer, int[][] computers, boolean[] visited) {
        visited[computer] = true;
        
        // 현재 컴퓨터와 연결된 모든 컴퓨터 탐색
        for (int i = 0; i < computers.length; i++) {
            if (computers[computer][i] == 1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }
}