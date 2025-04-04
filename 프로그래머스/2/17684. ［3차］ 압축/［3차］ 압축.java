import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dictionary = new HashMap<>();
        IntStream.range(0, 26).forEach(i ->{
            dictionary.put(String.valueOf((char) ('A' + i)), i + 1);
        });
        int dictionarySize = 27; // 'Z' 다음부터 시작

        List<Integer> answer = new ArrayList<>();

        int idx = 0;
        while (idx < msg.length()) {
            String w = "";
            String cur = "";

            // 사전에서 가장 긴 문자열 찾기
            while (idx < msg.length()) {
                cur = w + msg.charAt(idx);
                if (dictionary.containsKey(cur)) {
                    w = cur;
                    idx++;
                } else {
                    break;
                }
            }
            // w의 색인 번호 출력
            answer.add(dictionary.get(w));

            // 문자열의 끝에 도달하지 않았다면 새 시퀀스를 사전에 추가
            dictionary.put(cur, dictionarySize++);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
