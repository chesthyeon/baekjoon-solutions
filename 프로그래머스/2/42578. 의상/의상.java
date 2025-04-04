import java.util.*;
import java.util.stream.*;


class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        Arrays.stream(clothes).forEach(clothe -> {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1); // 수정: clothe[0]에서 clothe[1]로 변경
        });

        return map.values().stream()
                .mapToInt(count -> count + 1) // 각 의상을 입지 않는 경우 추가
                .reduce(1, (a, b) -> a * b) - 1; // 모든 의상을 입지 않는 경우 제외
    }
}
