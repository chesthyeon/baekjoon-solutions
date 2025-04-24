import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> (a[1] - b[1]));
        int cnt = 0;
        int cur = Integer.MIN_VALUE;
        for (int[] route : routes) {
            if (cur >= route[0]) {
                continue;
            }
            cur = route[1];
            cnt += 1;
        }
        return cnt;
    }
}