class Solution {
    public int solution(String[][] board, int h, int w) {
        int count = 0;
        int n = board.length;
        
        // 상하좌우 방향
        int[] dh = {-1, 1, 0, 0};  // 행 방향 이동
        int[] dw = {0, 0, -1, 1};  // 열 방향 이동
        
        // 주어진 칸의 색상
        String color = board[h][w];
        
        // 상하좌우 칸 확인
        for (int i = 0; i < 4; i++) {
            int nh = h + dh[i];
            int nw = w + dw[i];
            
            // 배열 범위 내에 있고, 색상이 같은 경우
            if (nh >= 0 && nh < n && nw >= 0 && nw < n && board[nh][nw].equals(color)) {
                count++;
            }
        }
        
        return count;
    }
}