class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        // 4방향 회전하며 모든 위치에서 시도
        for (int r = 0; r < 4; r++) {
            if (canOpen(key, lock)) return true;
            key = rotate(key);
        }
        return false;
    }
    
    // 열쇠로 자물쇠를 열 수 있는지 확인
    private boolean canOpen(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        
        // 열쇠를 모든 위치에 놓아보기
        for (int i = -m + 1; i < n; i++) {
            for (int j = -m + 1; j < n; j++) {
                if (isMatch(key, lock, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // 특정 위치에서 열쇠와 자물쇠가 맞는지 확인
    private boolean isMatch(int[][] key, int[][] lock, int startX, int startY) {
        int n = lock.length;
        int m = key.length;
        
        // 임시 자물쇠 생성
        int[][] temp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i][j] = lock[i][j];
            }
        }
        
        // 열쇠 적용
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                int x = startX + i;
                int y = startY + j;
                
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    temp[x][y] += key[i][j];
                }
            }
        }
        
        // 모든 칸이 1인지 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (temp[i][j] != 1) return false;
            }
        }
        
        return true;
    }
    
    // 90도 회전
    private int[][] rotate(int[][] arr) {
        int n = arr.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][n - 1 - i] = arr[i][j];
            }
        }
        return result;
    }
}