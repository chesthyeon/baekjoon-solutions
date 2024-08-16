class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }
    
    private int dfs(int[] numbers, int index, int sum, int target) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        
        int plusResult = dfs(numbers, index + 1, sum + numbers[index], target);
        int minusResult = dfs(numbers, index + 1, sum - numbers[index], target);
        
        return plusResult + minusResult;
    }
}