import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        // 결과를 저장할 TreeSet (자동 정렬 및 중복 제거)
        TreeSet<String> result = new TreeSet<>();
        
        // 각 코스 길이별로 처리
        for (int courseLength : course) {
            // 메뉴 조합별 주문 횟수 저장
            Map<String, Integer> combinations = new HashMap<>();
            int maxCount = 0;
            
            // 각 주문에 대해 가능한 조합 생성
            for (String order : orders) {
                // 메뉴를 알파벳 순으로 정렬
                char[] orderChars = order.toCharArray();
                Arrays.sort(orderChars);
                
                // 현재 주문에서 courseLength 길이의 조합 생성
                generateCombinations(new String(orderChars), 0, courseLength, "", combinations);
            }
            
            // 최대 주문 횟수 찾기
            for (int count : combinations.values()) {
                maxCount = Math.max(maxCount, count);
            }
            
            // 최소 2명 이상의 손님이 주문했고, 최대 주문 횟수와 같은 메뉴 조합 선택
            if (maxCount >= 2) {
                for (Map.Entry<String, Integer> entry : combinations.entrySet()) {
                    if (entry.getValue() == maxCount) {
                        result.add(entry.getKey());
                    }
                }
            }
        }
        
        // 결과 반환
        return result.toArray(new String[0]);
    }
    
    // 조합 생성 함수 (백트래킹)
    private void generateCombinations(String order, int start, int length, String current, Map<String, Integer> combinations) {
        if (current.length() == length) {
            // 완성된 조합을 맵에 추가하고 카운트 증가
            combinations.put(current, combinations.getOrDefault(current, 0) + 1);
            return;
        }
        
        // 백트래킹을 통한 조합 생성
        for (int i = start; i < order.length(); i++) {
            generateCombinations(order, i + 1, length, current + order.charAt(i), combinations);
        }
    }
}