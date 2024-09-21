class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length - 1};
        int left = 0, right = 0;
        int minLength = sequence.length;
        int sum = 0;
        while (right < sequence.length){
            sum += sequence[right];

            while (sum >= k){
                if (sum == k){
                    if (right - left < minLength || (right - left == minLength && answer[0] > left)){
                        answer[0] = left;
                        answer[1] = right;
                        minLength = right - left;
                    }
                }
                sum -= sequence[left];
                left++;
            }
            right++;
        }
        return answer;
    }
}