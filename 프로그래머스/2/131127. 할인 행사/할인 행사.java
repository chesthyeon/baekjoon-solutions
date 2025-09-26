import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 원하는 제품-수량 맵 생성
        Map<String, Integer> wantMap = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        int answer = 0;
        
        // 슬라이딩 윈도우로 10일씩 체크
        for (int start = 0; start <= discount.length - 10; start++) {
            Map<String, Integer> windowMap = new HashMap<>();
            
            // 현재 10일간의 할인 제품 카운팅
            for (int i = start; i < start + 10; i++) {
                windowMap.merge(discount[i], 1, Integer::sum);
            }
            
            // 원하는 것과 일치하는지 확인
            if (windowMap.equals(wantMap)) {
                answer++;
            }
        }
        
        return answer;
    }
}