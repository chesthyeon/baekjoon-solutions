import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        s += s;
        
        for (int i = 0; i < length; i++) {
            String rotated = s.substring(i, length + i);
            if (check(rotated)) {
                answer++;
            }
        }
        return answer;
    }
    
    boolean check(String s){
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        for(char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (map.get(c) != stack.pop()) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}