import java.util.*;

class Solution {
    int answer;
    int len;
    public int solution(int[] numbers, int target) {
        answer = 0;
        len = numbers.length;
        dfs(numbers, target, 0, 0);
        return answer;
    }
    public void dfs(int[] numbers, int target, int cnt, int sum){
        if (cnt == len) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        dfs(numbers, target, cnt + 1, sum + numbers[cnt]);
        dfs(numbers, target, cnt + 1, sum - numbers[cnt]);
        
    }
}