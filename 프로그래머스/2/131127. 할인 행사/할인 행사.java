import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        // 원하는 제품과 수량을 HashMap에 저장
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        // 10일 연속으로 할인하는 날짜를 탐색
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountMap = new HashMap<>();
            
            // 현재 시작일부터 10일간의 할인 제품 집계
            for (int j = 0; j < 10; j++) {
                String item = discount[i + j];
                discountMap.put(item, discountMap.getOrDefault(item, 0) + 1);
            }
            
            // 원하는 제품의 수량과 할인 제품의 수량이 일치하는지 확인
            if (wantMap.equals(discountMap)) {
                answer++;
            }
        }
        
        return answer;
    }
}