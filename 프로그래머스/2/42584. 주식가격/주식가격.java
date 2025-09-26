import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        
        int[] ans = new int[prices.length];
        
        for(int i = 1; i < prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
               int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int idx = stack.pop();
            ans[idx] = prices.length - idx - 1;
        }
        
        return ans;
    }
}