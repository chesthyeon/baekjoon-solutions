import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];
        for (int[] puddle : puddles) {
            int x = puddle[0], y = puddle[1];
            map[y][x] = -1;
        }

        map[1][1] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == -1 || (i == 1 && j == 1)) {
                    continue;
                }
                int up = map[i - 1][j] == -1 ? 0 : map[i - 1][j];
                int left = map[i][j - 1] == -1 ? 0 : map[i][j - 1];

                map[i][j] = (up + left) % 1_000_000_007;
            }
        }

        return map[n][m];
    }
}