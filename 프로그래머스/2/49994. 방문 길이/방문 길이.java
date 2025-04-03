import java.util.*;
import java.util.stream.*;

class Solution {
    static boolean isValid(int nx, int ny) {
        return 0 <= nx && nx < 11 && 0 <= ny && ny < 11;
    }
    static HashMap<Character, int[]> location = new HashMap<>();
    static void initLocation() {
        location.put('U', new int[] {-1, 0});
        location.put('D', new int[] {1, 0});
        location.put('R', new int[] {0, 1});
        location.put('L', new int[] {0, -1});
    }
    public int solution(String dirs) {
        initLocation();
        int ans = 0;
        int x = 5;
        int y = 5;
        boolean[][][][] visited = new boolean[11][11][11][11];
        for (char c : dirs.toCharArray()) {
            int nx = x + location.get(c)[0];
            int ny = y + location.get(c)[1];
            if (!isValid(nx, ny)) {
                continue;
            }
            if (!visited[x][y][nx][ny]) {
                visited[x][y][nx][ny] = true;
                visited[nx][ny][x][y] = true;
                ans++;
            }

            x = nx;
            y = ny;
        }
        return ans;
    }
}