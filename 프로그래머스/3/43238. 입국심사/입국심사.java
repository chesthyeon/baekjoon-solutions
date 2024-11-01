class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        // right 값 계산
        long max = 0;
        for (int time : times) {
            max = Math.max(max, time);
        }
        
        long left = 1;
        long right = max * n;  // 최대 소요시간
        
        while (left <= right) {
            long mid = left + (right - left) / 2;  // 오버플로우 방지
            
            // 심사 가능한 인원 계산
            long sum = 0;
            for (int time : times) {
                sum += mid / time;  // 각 심사대에서 처리 가능한 인원
                if (sum >= n) break;  // 최적화
            }
            
            if (sum >= n) {  // 심사 가능한 인원이 n 이상
                answer = Math.min(answer, mid);  // 최솟값 갱신
                right = mid - 1;  // 더 작은 시간 탐색
            } else {  // 심사 가능한 인원이 n 미만
                left = mid + 1;  // 더 큰 시간 탐색
            }
        }
        
        return answer;
    }
}