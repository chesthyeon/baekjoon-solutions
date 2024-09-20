class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int[] dh = {-1, 1, 0, 0};
        int[] dw = {0, 0, -1, 1};
        String color = board[h][w];
        for (int i = 0; i < 4; i++){
            int nh = h + dh[i];
            int nw = w + dw[i];
            if (nh >= 0 && nh < n && nw >= 0 && nw < n && color.equals(board[nh][nw])){
                answer++;
            }
        }
        return answer;
    }
}