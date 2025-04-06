import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);
            
            // 스택이 비어있지 않고, 스택의 top이 현재 숫자보다 작고, 아직 제거할 숫자가 남아있을 때
            while (!stack.isEmpty() && stack.peek() < current && k > 0) {
                stack.pop(); // 작은 숫자 제거
                k--;
            }
            
            stack.push(current);
        }
        
        // k가 남아있는 경우 (모든 숫자를 순회했는데도 k개를 제거하지 못한 경우)
        while (k > 0) {
            stack.pop();
            k--;
        }
        
        // 스택을 문자열로 변환 (스트림과 람다 사용)
        return stack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
    }
}