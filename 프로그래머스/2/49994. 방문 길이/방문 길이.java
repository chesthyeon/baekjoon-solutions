import java.util.*;
class Solution {
    public int solution(String dirs) {
        Map<Character, int[]> map = new HashMap<>();
        map.put('U', new int[]{0, 1});
        map.put('D', new int[]{0, -1});
        map.put('L', new int[]{-1, 0});
        map.put('R', new int[]{1, 0});
        
        Set<String> set = new HashSet<>();
        int x = 5, y = 5;
        for(char c : dirs.toCharArray()){
            int[] cmd = map.get(c);
            int nx = x + cmd[0];
            int ny = y + cmd[1];
            if(nx < 0 || nx > 10 || ny < 0 || ny > 10) continue;
            set.add(x + " " + y + " " + nx + " " + ny);
            set.add(nx + " " + ny + " " + x + " " + y);
            x = nx;
            y = ny;
            
        }
        return set.size() / 2;
    }
}