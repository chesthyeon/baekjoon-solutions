class Solution {
    public int solution(int n) {
        boolean[] w = new boolean[n];
        boolean[] dUp = new boolean[n * 2];
        boolean[] dDown = new boolean[n * 2];
        return dfs(n, 0, w, dUp, dDown);
    }

    int dfs(int n, int row,  boolean[] w, boolean[] dUp, boolean[] dDown){
        if (row == n) {
            return 1;
        }

        int cnt = 0;
        for (int col = 0; col < n; col++) {
            if(!w[col] && !dUp[row+col] && !dDown[col-row+n]){
                w[col] = true;
                dUp[row+col] = true;
                dDown[col - row + n] = true;

                cnt += dfs(n, row + 1, w, dUp, dDown);

                w[col] = false;
                dUp[row+col] = false;
                dDown[col - row + n] = false;
            }
        }
        return cnt;
    }
}