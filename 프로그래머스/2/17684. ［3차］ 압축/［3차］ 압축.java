import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 1. 사전 초기화 (A~Z)
        HashMap<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dictionary.put(String.valueOf((char)('A' + i)), i + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        int dictIndex = 27; // 다음 사전 인덱스 (Z 다음부터)
        
        // 2. 문자열 처리
        int i = 0;
        while (i < msg.length()) {
            String w = String.valueOf(msg.charAt(i));
            i++;
            
            // 사전에 있는 가장 긴 문자열 찾기
            while (i < msg.length() && dictionary.containsKey(w + msg.charAt(i))) {
                w += msg.charAt(i);
                i++;
            }
            
            // 현재 문자열의 색인 추가
            result.add(dictionary.get(w));
            
            // 새로운 문자열 사전에 추가 (마지막 문자가 아닐 경우)
            if (i < msg.length()) {
                dictionary.put(w + msg.charAt(i), dictIndex++);
            }
        }
        
        // 리스트를 배열로 변환
        int[] answer = new int[result.size()];
        for (int j = 0; j < result.size(); j++) {
            answer[j] = result.get(j);
        }
        
        return answer;
    }
}