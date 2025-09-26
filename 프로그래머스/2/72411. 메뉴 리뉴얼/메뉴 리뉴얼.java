import java.util.*;

public class Solution {
    private Map<String, Integer> combCount;
    
    public String[] solution(String[] orders, int[] course) {
        List<String> result = new ArrayList<>();
        
        // 각 코스 길이별로 처리
        for (int courseLen : course) {
            combCount = new HashMap<>();
            
            // 모든 주문에서 해당 길이의 조합 생성
            for (String order : orders) {
                char[] chars = order.toCharArray();
                Arrays.sort(chars);  // 정렬해서 조합 순서 통일
                generateCombinations(chars, 0, "", courseLen);
            }
            
            // 최다 주문된 조합들 찾기
            int maxCount = combCount.values().stream()
                                   .mapToInt(Integer::intValue)
                                   .filter(count -> count >= 2)  // 최소 2번 이상
                                   .max()
                                   .orElse(0);
            
            if (maxCount >= 2) {
                for (Map.Entry<String, Integer> entry : combCount.entrySet()) {
                    if (entry.getValue() == maxCount) {
                        result.add(entry.getKey());
                    }
                }
            }
        }
        
        Collections.sort(result);
        return result.toArray(new String[0]);
    }
    
    // 조합 생성 (백트래킹)
    private void generateCombinations(char[] order, int start, String current, int targetLen) {
        if (current.length() == targetLen) {
            combCount.merge(current, 1, Integer::sum);
            return;
        }
        
        for (int i = start; i < order.length; i++) {
            generateCombinations(order, i + 1, current + order[i], targetLen);
        }
    }
}