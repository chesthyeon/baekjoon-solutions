import java.util.*;

class Solution {
    public String solution(String number, int k) {
        // 스택을 사용해서 결과 구성
        Stack<Character> stack = new Stack<>();
        int removeCount = 0; // 제거한 숫자의 개수
        
        // 왼쪽부터 각 숫자를 확인
        for (char digit : number.toCharArray()) {
            // 현재 숫자가 스택의 top보다 크고, 아직 제거할 숫자가 남아있으면
            while (!stack.isEmpty() && 
                   stack.peek() < digit && 
                   removeCount < k) {
                stack.pop();     // 작은 숫자 제거
                removeCount++;   // 제거 개수 증가
            }
            
            stack.push(digit);   // 현재 숫자 추가
        }
        
        // k개를 모두 제거하지 못한 경우 (뒤에서부터 제거)
        while (removeCount < k) {
            stack.pop();
            removeCount++;
        }
        
        // 스택을 문자열로 변환
        StringBuilder sb = new StringBuilder();
        for (char digit : stack) {
            sb.append(digit);
        }
        
        return sb.toString();
    }
}