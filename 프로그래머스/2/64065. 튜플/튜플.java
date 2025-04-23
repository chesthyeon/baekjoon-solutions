import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 입력 문자열에서 숫자만 추출해서 빈도수 계산
        Map<Integer, Integer> freq = new HashMap<>();
        
        // 중괄호와 쉼표 제거 후 숫자만 추출
        s = s.replaceAll("[{}]", "");
        String[] numbers = s.split(",");
        
        // 각 숫자의 등장 빈도 계산
        for (String num : numbers) {
            int n = Integer.parseInt(num);
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        
        // 빈도수 기준 내림차순 정렬
        List<Integer> result = new ArrayList<>(freq.keySet());
        result.sort((a, b) -> freq.get(b) - freq.get(a));
        
        // 결과 반환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}