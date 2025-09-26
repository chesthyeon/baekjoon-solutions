import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
    int[] answer = new int[(int)(right - left) + 1];
    
    for(int i = 0; i < answer.length; i++){
        long currentIndex = left + i;  // left를 직접 수정하지 않음
        int row = (int)(currentIndex / n) + 1;
        int col = (int)(currentIndex % n) + 1;  
        answer[i] = Math.max(row, col);
    }
    
    return answer;
}
}