class Solution {
    public int[] solution(int[] sequence, int k) {
        int left = 0;
        int sum = 0;
        int bestLength = Integer.MAX_VALUE;
        int[] result = new int[2];
        
        for (int right = 0; right < sequence.length; right++) {
            // 오른쪽 확장
            sum += sequence[right];
            
            // sum이 k보다 크면 왼쪽 축소
            while (sum > k && left <= right) {
                sum -= sequence[left];
                left++;
            }
            
            // 목표 합 발견!
            if (sum == k) {
                int currentLength = right - left + 1;
                if (currentLength < bestLength) {
                    bestLength = currentLength;
                    result[0] = left;
                    result[1] = right;
                }
            }
        }
        
        return result;
    }
}