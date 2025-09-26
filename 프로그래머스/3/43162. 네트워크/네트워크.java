class Solution {
    static boolean[] visited;
    static int[][] computers;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        this.computers = computers;
        int networkCount = 0;
        
        // 모든 컴퓨터를 확인
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // 새로운 네트워크 발견
                dfs(i);
                networkCount++;
            }
        }
        
        return networkCount;
    }
    
    void dfs(int computer) {
        visited[computer] = true;
        
        // 현재 컴퓨터와 연결된 모든 컴퓨터 탐색
        for (int i = 0; i < computers.length; i++) {
            if (computers[computer][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}