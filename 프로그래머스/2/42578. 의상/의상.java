import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 1. 의상 종류별 개수를 저장할 HashMap
        HashMap<String, Integer> clothesCount = new HashMap<>();
        
        // 2. 각 의상을 종류별로 분류하여 개수 세기
        for (String[] item : clothes) {
            String clothesName = item[0]; // 의상 이름 (실제로는 사용 안함)
            String clothesType = item[1]; // 의상 종류 (중요!)
            
            // 해당 종류의 의상 개수 증가
            clothesCount.put(clothesType, clothesCount.getOrDefault(clothesType, 0) + 1);
        }
        
        // 3. 조합의 수 계산
        int result = 1;
        
        // 각 의상 종류별로 (개수 + 1)을 곱함
        // +1은 해당 종류를 아예 입지 않는 경우를 포함
        for (int count : clothesCount.values()) {
            result *= (count + 1);
        }
        
        // 4. 알몸인 경우(모든 종류를 입지 않는 경우) 1가지 제외
        return result - 1;
    }
}