import java.util.Arrays;

public class Solution {
    public long solution(long n) {
        // 정수를 문자열로 변환 후 문자 배열로 만들기
        String[] digits = String.valueOf(n).split("");
        
        // 람다식을 사용한 내림차순 정렬
        Arrays.sort(digits, (a, b) -> b.compareTo(a));
        
        // 문자열로 합치고 정수로 변환
        return Long.parseLong(String.join("", digits));
    }
}