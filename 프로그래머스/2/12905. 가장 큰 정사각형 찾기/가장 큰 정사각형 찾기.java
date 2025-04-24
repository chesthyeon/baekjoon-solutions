class Solution
{
    public int solution(int [][]board)
    {
        int h = board.length;
        int w = board[0].length;
        int ans = 0;

        for (int i = 0; i < h; i++) {
            if (board[i][0] == 1) ans = 1;
        }
        for (int j = 0; j < w; j++) {
            if (board[0][j] == 1) ans = 1;
        }
        
        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (board[i][j] == 0) continue;
                board[i][j] = Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j], board[i][j - 1])) + 1;
                ans = Math.max(board[i][j], ans);
            }
        }
        return ans*ans;
    }
}