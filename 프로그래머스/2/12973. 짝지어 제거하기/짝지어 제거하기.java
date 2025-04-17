import java.util.*;

class Solution
{
    public int solution(String s)
    {
        ArrayDeque<Character> deque = new ArrayDeque<>();
        deque.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!deque.isEmpty() && deque.peek() == s.charAt(i)) {
                deque.pop();
            } else {
                deque.push(s.charAt(i));
            }
        }

        return deque.isEmpty() ? 1 : 0;
    }
}