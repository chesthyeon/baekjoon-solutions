import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        // 이름과 그리움 점수를 매핑하는 HashMap 생성
        Map<String, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            scoreMap.put(name[i], yearning[i]);
        }
        
        // 각 사진의 추억 점수를 계산
        int[] result = new int[photo.length];
        for (int i = 0; i < photo.length; i++) {
            int score = 0;
            for (String person : photo[i]) {
                score += scoreMap.getOrDefault(person, 0);
            }
            result[i] = score;
        }
        
        return result;
    }
}