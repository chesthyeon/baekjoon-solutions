import java.util.*;

class Solution {
    public int solution(String s) {
        // 닫는 괄호와 여는 괄호를 매핑
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        // 결과 변수
        int answer = 0;
        
        // 문자열을 덱에 넣기
        ArrayDeque<Character> originalDeque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            originalDeque.add(c);
        }
        
        // 문자열 길이만큼 회전
        for (int i = 0; i < s.length(); i++) {
            // 현재 상태의 덱을 복사해서 올바른 괄호 문자열인지 검사
            ArrayDeque<Character> checkDeque = new ArrayDeque<>(originalDeque);
            
            // 괄호 검사를 위한 스택
            Stack<Character> stack = new Stack<>();
            boolean isValid = true;
            
            // 현재 상태의 덱에서 모든 문자 검사
            while (!checkDeque.isEmpty()) {
                char current = checkDeque.poll();
                
                // 여는 괄호면 스택에 추가
                if (!map.containsKey(current)) {
                    stack.push(current);
                } 
                // 닫는 괄호면 짝이 맞는지 확인
                else {
                    if (stack.isEmpty() || stack.pop() != map.get(current)) {
                        isValid = false;
                        break;
                    }
                }
            }
            
            // 모든 괄호가 짝이 맞는지 확인
            if (isValid && stack.isEmpty()) {
                answer++;
            }
            
            // 원본 덱 회전 (맨 앞 문자를 맨 뒤로)
            if (i < s.length() - 1) {  // 마지막 회전은 불필요
                originalDeque.add(originalDeque.poll());
            }
        }
        
        return answer;
    }
}