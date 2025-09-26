import java.util.*;

class Solution {
    public int[] solution(String msg) {
        // 1. 사전 초기화 (A~Z = 1~26)
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dict.put("" + (char)('A' + i), i + 1);
        }
        
        List<Integer> result = new ArrayList<>();
        int dictNum = 27;  // 다음에 추가할 사전 번호
        String current = "";  // 현재 처리중인 문자열
        
        for (char c : msg.toCharArray()) {
            String next = current + c;
            
            if (dict.containsKey(next)) {
                // 사전에 있으면 계속 확장
                current = next;
            } else {
                // 사전에 없으면
                result.add(dict.get(current));     // 현재 문자열 출력
                dict.put(next, dictNum++);         // 새 문자열 사전에 추가
                current = "" + c;                  // 현재 문자부터 다시 시작
            }
        }
        
        // 마지막 문자열 처리
        if (!current.isEmpty()) {
            result.add(dict.get(current));
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}