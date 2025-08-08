import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        // 전체 보석 종류 수 계산
        Set<String> gemTypes = new HashSet<>(Arrays.asList(gems));
        int totalTypes = gemTypes.size();
        
        // 투 포인터와 HashMap 초기화
        Map<String, Integer> window = new HashMap<>();
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int[] result = {1, gems.length};
        
        for (int right = 0; right < gems.length; right++) {
            // 오른쪽 확장: 보석 추가
            window.put(gems[right], window.getOrDefault(gems[right], 0) + 1);
            
            // 모든 보석 종류를 포함할 때까지 왼쪽 축소
            while (window.size() == totalTypes) {
                // 더 짧은 구간 발견 시 갱신
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    result[0] = left + 1;  // 1-based 인덱스
                    result[1] = right + 1;
                }
                
                // 왼쪽 보석 제거
                String leftGem = gems[left];
                window.put(leftGem, window.get(leftGem) - 1);
                if (window.get(leftGem) == 0) {
                    window.remove(leftGem);
                }
                left++;
            }
        }
        
        return result;
    }
}