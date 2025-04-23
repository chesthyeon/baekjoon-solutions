import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        // 숫자들을 문자열 배열로 변환
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        // 정렬: a+b와 b+a를 비교하여 더 큰 숫자 조합이 앞으로 오도록
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));
        
        // 정렬된 결과가 0으로 시작한다면 모든 숫자가 0이라는 의미
        if (strNumbers[0].equals("0")) {
            return "0";
        }
        
        // 정렬된 결과를 하나의 문자열로 연결
        StringBuilder answer = new StringBuilder();
        for (String str : strNumbers) {
            answer.append(str);
        }
        
        return answer.toString();
    }
}