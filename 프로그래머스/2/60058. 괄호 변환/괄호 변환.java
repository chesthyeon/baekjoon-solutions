import java.util.*;

class Solution {
    public String solution(String p) {
        if (p.equals("")) {
            return p;
        }
        StringBuilder sb = new StringBuilder();
        int right = 0, left = 0;
        for (char ch : p.toCharArray()) {
            if (ch == '(') {
                left++;
            } else {
                right++;
            }
            if (right == left) {
                break;
            }
        }
        String u = p.substring(0, left + right);
        String v = p.substring(left + right);
        if (toCorrect(u)) {
            sb.append(u).append(solution(v));
            System.out.println(sb);
        } else {
            sb.append("(").append(solution(v)).append(")");
            for (int i = 1; i < u.length() - 1; i++) {
                sb.append(u.charAt(i) == '(' ? ')' : '(');
            }
        }
        return  sb.toString();
    }

    public boolean toCorrect(String u) {
        Stack<Character> stack = new Stack<>();
        for (char ch : u.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else if (!stack.isEmpty()){
                stack.pop();
            } else return false;
        }
        return stack.isEmpty();
    }
}