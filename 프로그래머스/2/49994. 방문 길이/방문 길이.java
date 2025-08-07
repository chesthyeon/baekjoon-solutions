import java.util.*;

public class Solution {
    public int solution(String dirs) {
        Set<String> visitedPaths = new HashSet<>();
        int x = 0, y = 0; // 시작점 (0,0)
        
        for (char dir : dirs.toCharArray()) {
            int nx = x, ny = y;
            
            // 방향에 따른 이동
            switch (dir) {
                case 'U': ny++; break;
                case 'D': ny--; break;
                case 'L': nx--; break;
                case 'R': nx++; break;
            }
            
            // 경계 체크
            if (nx < -5 || nx > 5 || ny < -5 || ny > 5) continue;
            
            // 길을 정규화해서 저장 (양방향이므로)
            String path = Math.min(x, nx) + "," + Math.min(y, ny) + 
                         "->" + Math.max(x, nx) + "," + Math.max(y, ny);
            visitedPaths.add(path);
            
            x = nx;
            y = ny;
        }
        
        return visitedPaths.size();
    }
}