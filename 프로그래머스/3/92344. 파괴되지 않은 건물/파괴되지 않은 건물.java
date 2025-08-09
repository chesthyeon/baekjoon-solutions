class Solution {
    public int solution(int[][] board, int[][] skill) {
        int N = board.length;
        int M = board[0].length;
        
        int[][] delta = new int[N + 1][M + 1];
        
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1], c1 = s[2];
            int r2 = s[3], c2 = s[4];
            int degree = s[5];
            
            if (type == 1) {
                degree = -degree;
            }
            
            delta[r1][c1] += degree;
            delta[r1][c2 + 1] += -degree;
            delta[r2 + 1][c1] += -degree;
            delta[r2 + 1][c2 + 1] += degree;
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < M; j++) {
                delta[i][j] += delta[i][j - 1];
            }
        }
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                delta[i][j] += delta[i - 1][j];
            }
        }
        
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] + delta[i][j] > 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}