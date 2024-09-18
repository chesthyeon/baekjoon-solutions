import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 100000; // 최대 난이도
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSolveAllPuzzles(diffs, times, mid, limit)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canSolveAllPuzzles(int[] diffs, int[] times, int level, long limit) {
        long totalTime = 0;
        int prevTime = 0;
        
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                totalTime += times[i];
            } else {
                long mistakes = diffs[i] - level;
                totalTime += mistakes * (times[i] + prevTime) + times[i];
            }
            
            if (totalTime > limit) {
                return false;
            }
            
            prevTime = times[i];
        }
        
        return true;
    }
}