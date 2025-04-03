import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] prices) {
        int n  = prices.length;
        int[] answer = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int top = stack.pop();
                answer[top] = i - top;
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int num = stack.pop();
            answer[num] = n -1 - num;
        }
        return answer;
    }
}