import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        // 각 크기별 개수 세기
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.merge(t, 1, (a, b) -> a + b);
        }
        
        // 개수 기준 내림차순 정렬
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Comparator.reverseOrder());
        
        // 필요한 최소 종류 계산
        int answer = 0;
        for (int count : counts) {
            k -= count;
            answer++;
            if (k <= 0) break;
        }
        
        return answer;
    }
}