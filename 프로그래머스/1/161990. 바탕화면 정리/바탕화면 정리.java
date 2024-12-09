import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = Integer.MAX_VALUE, maxX = Integer.MIN_VALUE, minY = Integer.MAX_VALUE, maxY = Integer.MIN_VALUE;
        for(int i = 0; i < wallpaper.length; i++){
            char[] charArr = wallpaper[i].toCharArray();
            for(int j = 0; j < charArr.length; j++){
                if(charArr[j] == '#'){
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        int[] answer = {minX, minY, maxX + 1, maxY + 1};
        return answer;
    }
}