import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();
        int n = elements.length;
        
        // 길이별로 모든 부분 수열 확인
        for (int length = 1; length <= n; length++) {
            // 각 시작 위치에서 
            for (int start = 0; start < n; start++) {
                int sum = 0;
                // length만큼의 연속 원소 합계
                for (int i = 0; i < length; i++) {
                    sum += elements[(start + i) % n];  // 원형 배열
                }
                sums.add(sum);
            }
        }
        
        return sums.size();
    }
}