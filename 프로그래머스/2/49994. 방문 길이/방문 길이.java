import java.util.*;

class Solution {
    public int solution(String dirs) {
        Map<Character, int[]> location = new HashMap();
        location.put('U',new int[]{-1, 0});
        location.put('D',new int[]{1, 0});
        location.put('L',new int[]{0, -1});
        location.put('R',new int[]{0, 1});
        
        int x = 5, y = 5;
        boolean[][][][] visited = new boolean[11][11][11][11];
        int ans = 0;
        
        for(char c : dirs.toCharArray()){
            int nx = x + location.get(c)[0];
            int ny = y + location.get(c)[1];
            
            if(0 > nx || nx > 10 || 0 > ny || ny > 10){
             continue;
            }
            
            if(visited[x][y][nx][ny]){
                x = nx;
                y = ny;
                continue;
            }
            
            visited[x][y][nx][ny] = true;
            visited[nx][ny][x][y] = true;
            ans++;
            
            x = nx;
            y = ny;
        }
        return ans;
    }
}