import java.util.*;
import java.util.stream.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i : arr) {
            if (!stack.isEmpty() && stack.peek() == i) {
                continue;
            }
            stack.push(i);
        }
        int[] answer = new int[stack.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}