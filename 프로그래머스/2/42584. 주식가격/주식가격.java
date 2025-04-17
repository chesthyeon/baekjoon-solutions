import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int[] ans = new int[prices.length];

        for (int i = 1; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int temp = stack.pop();
                ans[temp] = i - temp;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            ans[idx] = prices.length - idx - 1;
        }

        return ans;
    }
}