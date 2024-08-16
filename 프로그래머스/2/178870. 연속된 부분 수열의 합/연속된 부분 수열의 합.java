class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int left = 0, right = 0;
        int sum = 0;
        int[] result = {0, n - 1}; // 초기값으로 전체 수열의 시작과 끝 인덱스 설정
        int minLength = n;

        while (right < n) {
            // 오른쪽 포인터를 이동하며 합을 증가
            sum += sequence[right];

            // 합이 k보다 크거나 같아지면 왼쪽 포인터를 이동
            while (sum >= k) {
                if (sum == k) {
                    // 현재 부분 수열의 길이가 이전에 찾은 것보다 짧거나,
                    // 길이가 같지만 시작 인덱스가 더 작은 경우 결과 업데이트
                    if (right - left < minLength || (right - left == minLength && left < result[0])) {
                        result[0] = left;
                        result[1] = right;
                        minLength = right - left;
                    }
                }
                sum -= sequence[left];
                left++;
            }
            right++;
        }

        return result;
    }
}