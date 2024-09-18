import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        // 돗자리 크기를 내림차순으로 정렬
        Arrays.sort(mats);
        for (int i = mats.length - 1; i >= 0; i--) {
            int size = mats[i];
            if (canPlace(park, size)) {
                return size;
            }
        }
        return -1;
    }
    
    private boolean canPlace(String[][] park, int size) {
        int rows = park.length;
        int cols = park[0].length;
        
        for (int i = 0; i <= rows - size; i++) {
            for (int j = 0; j <= cols - size; j++) {
                if (checkSpace(park, i, j, size)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean checkSpace(String[][] park, int startRow, int startCol, int size) {
        for (int i = startRow; i < startRow + size; i++) {
            for (int j = startCol; j < startCol + size; j++) {
                if (!park[i][j].equals("-1")) {
                    return false;
                }
            }
        }
        return true;
    }
}