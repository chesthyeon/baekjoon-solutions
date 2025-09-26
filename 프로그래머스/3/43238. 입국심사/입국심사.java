import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 1;
        long right = (long) Arrays.stream(times).max().getAsInt() * n;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long pass = 0;
            
            for (int time : times) {
                pass += mid / time;
            }
            
            if (pass >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}