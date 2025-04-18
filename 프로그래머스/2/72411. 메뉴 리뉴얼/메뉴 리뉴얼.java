import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for (int length : course) {
            Map<String, Integer> combinations = new HashMap<>();
            int maxCount = 0;
            
            // 각 주문에서 조합 생성
            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);  // 알파벳 순으로 정렬
                findCombinations(chars, 0, length, "", combinations);
            }
            
            // 최대 주문 횟수 찾기
            for (int count : combinations.values()) {
                maxCount = Math.max(maxCount, count);
            }
            
            // 최대 주문 횟수인 메뉴 조합만 추가 (2회 이상인 경우만)
            if (maxCount >= 2) {
                for (Map.Entry<String, Integer> entry : combinations.entrySet()) {
                    if (entry.getValue() == maxCount) {
                        answer.add(entry.getKey());
                    }
                }
            }
        }
        
        // 알파벳 순으로 정렬
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    // 조합 생성 (DFS 사용)
    private void findCombinations(char[] order, int start, int length, String current, Map<String, Integer> combinations) {
        if (current.length() == length) {
            combinations.put(current, combinations.getOrDefault(current, 0) + 1);
            return;
        }
        
        for (int i = start; i < order.length; i++) {
            findCombinations(order, i + 1, length, current + order[i], combinations);
        }
    }
}