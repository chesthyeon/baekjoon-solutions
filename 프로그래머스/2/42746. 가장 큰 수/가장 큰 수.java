import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 숫자들을 문자열로 변환
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        // 정렬
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));
        
        // 결과 문자열 생성
        if (strNumbers[0].equals("0")) return "0";  // 모든 숫자가 0인 경우
        
        StringBuilder answer = new StringBuilder();
        for (String s : strNumbers) {
            answer.append(s);
        }
        
        return answer.toString();
    }
}