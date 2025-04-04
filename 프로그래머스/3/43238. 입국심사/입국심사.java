import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        // 최소 시간 찾기를 위한 이진 탐색
        long left = 1;
        long right = getMaximumTime(n, times);
        long answer = right; // 최악의 경우를 초기값으로 설정
        
        while (left <= right) {
            long mid = left + (right - left) / 2;
            
            if (canProcessAll(n, times, mid)) {
                answer = mid; // 가능한 시간 저장
                right = mid - 1; // 더 적은 시간 탐색
            } else {
                left = mid + 1; // 더 많은 시간 필요
            }
        }
        
        return answer;
    }
    
    // 주어진 시간 내에 모든 사람을 처리할 수 있는지 확인
    private boolean canProcessAll(int people, int[] times, long timeLimit) {
        long processedPeople = 0;
        
        for (int time : times) {
            processedPeople += timeLimit / time;
            if (processedPeople >= people) return true; // 최적화: 충분히 처리 가능하면 즉시 반환
        }
        
        return false;
    }
    
    // 최대 소요 시간 계산 (가장 느린 심사관이 모든 사람 처리)
    private long getMaximumTime(int people, int[] times) {
        return (long) Arrays.stream(times).max().getAsInt() * people;
    }
}