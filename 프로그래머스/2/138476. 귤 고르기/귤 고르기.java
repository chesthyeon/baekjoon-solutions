import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> tangerineMap = new HashMap<>();
        for(int t : tangerine) tangerineMap.put(t, tangerineMap.getOrDefault(t, 0) + 1);
        List<Integer> sortedTangerine = new ArrayList<>(tangerineMap.values());
        sortedTangerine.sort(((o1, o2) -> o2 - o1));
        int cnt = 0;
        for (int i : sortedTangerine) {
            cnt++;
            k -= i;
            if (k <= 0) {
                return cnt;
            }
        }
        return cnt; // 모든 귤을 사용해도 k개를 채우지 못하는 경우 (문제 조건상 발생하지 않을 것)
    }
}