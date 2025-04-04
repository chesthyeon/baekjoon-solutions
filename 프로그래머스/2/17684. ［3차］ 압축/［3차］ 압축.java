import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 결과를 저장할 리스트
        List<Integer> result = new ArrayList<>();
        
        // 사전 초기화 (A-Z)
        HashMap<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            dictionary.put(String.valueOf(c), i + 1);
        }
        
        int dictSize = 26; // 현재 사전 크기
        
        int idx = 0;
        while (idx < msg.length()) {
            String w = ""; // 현재 일치하는 문자열
            
            // 사전에 있는 가장 긴 문자열 찾기
            while (idx < msg.length()) {
                String temp = w + msg.charAt(idx);
                if (dictionary.containsKey(temp)) {
                    w = temp;
                    idx++;
                } else {
                    break;
                }
            }
            
            // 현재 일치하는 단어의 색인 번호 출력
            result.add(dictionary.get(w));
            
            // 다음 글자가 있다면 사전에 추가
            if (idx < msg.length()) {
                String newEntry = w + msg.charAt(idx);
                dictionary.put(newEntry, ++dictSize);
            }
        }
        
        // List를 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}