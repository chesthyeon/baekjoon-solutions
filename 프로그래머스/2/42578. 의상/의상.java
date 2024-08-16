import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 의상 종류별 개수를 저장할 HashMap 생성
        Map<String, Integer> clothesMap = new HashMap<>();
        
        // 의상 종류별 개수 계산
        for (String[] cloth : clothes) {
            String type = cloth[1];
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
        }
        
        // 조합 계산
        int answer = 1;
        for (int count : clothesMap.values()) {
            // 각 종류별로 안 입는 경우를 포함하여 계산
            answer *= (count + 1);
        }
        
        // 아무것도 입지 않는 경우 제외
        return answer - 1;
    }
}