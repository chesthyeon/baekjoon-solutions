import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 숫자들을 문자열로 변환하여 저장할 배열 생성
        String[] strNumbers = new String[numbers.length];
        
        // int 배열을 String 배열로 변환
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        // 커스텀 정렬 구현
        // 두 수를 이어붙였을 때 더 큰 수가 되는 순서대로 정렬
        Arrays.sort(strNumbers, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1); // 내림차순 정렬
        });
        
        // 모든 수가 0인 경우 처리
        if (strNumbers[0].equals("0")) {
            return "0";
        }
        
        // 정렬된 문자열들을 하나로 이어붙임
        StringBuilder answer = new StringBuilder();
        for (String str : strNumbers) {
            answer.append(str);
        }
        
        return answer.toString();
    }
}