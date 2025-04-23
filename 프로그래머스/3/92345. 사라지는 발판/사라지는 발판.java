class Solution {
    // 상하좌우 이동 방향
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[][] board;
    int rows, cols;
    
    public int solution(int[][] board, int[] aloc, int[] bloc) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        
        // A 플레이어부터 시작
        return play(aloc[0], aloc[1], bloc[0], bloc[1], true);
    }
    
    // 게임 진행 함수
    // curX, curY: 현재 플레이어 위치
    // otherX, otherY: 상대 플레이어 위치
    // isATurn: A 플레이어 차례인지 여부
    private int play(int curX, int curY, int otherX, int otherY, boolean isATurn) {
        // 현재 위치가 이미 발판이 없으면 패배 (0 반환)
        if (board[curX][curY] == 0) {
            return 0;
        }
        
        int win = Integer.MAX_VALUE;  // 이기는 경우 최소 턴 수
        int lose = 0;                // 지는 경우 최대 턴 수
        boolean canMove = false;     // 이동 가능 여부
        
        // 현재 발판 제거
        board[curX][curY] = 0;
        
        // 네 방향 탐색
        for (int[] dir : dirs) {
            int nx = curX + dir[0];
            int ny = curY + dir[1];
            
            // 유효한 이동인지 확인
            if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && board[nx][ny] == 1) {
                canMove = true;
                
                // 재귀적으로 다음 턴 진행
                int turns = play(otherX, otherY, nx, ny, !isATurn) + 1;
                
                // 턴 수의 홀짝으로 승패 판단
                // 홀수: 현재 플레이어 승리, 짝수: 현재 플레이어 패배
                if (turns % 2 == 1) {
                    // 이기는 경우, 최소 턴 수 선택
                    win = Math.min(win, turns);
                } else {
                    // 지는 경우, 최대 턴 수 선택
                    lose = Math.max(lose, turns);
                }
            }
        }
        
        // 발판 복구
        board[curX][curY] = 1;
        
        // 이동할 수 없으면 패배
        if (!canMove) {
            return 0;
        }
        
        // 이길 수 있으면 최소 턴 수, 아니면 최대 턴 수 반환
        return (win != Integer.MAX_VALUE) ? win : lose;
    }
}