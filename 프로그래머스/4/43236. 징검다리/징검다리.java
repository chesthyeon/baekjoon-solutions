class Solution {
    public int solution(int distance, int[] rocks, int n) {
        // 바위 위치 정렬
        java.util.Arrays.sort(rocks);
        
        // 이진 탐색을 위한 left, right 설정
        long left = 1;
        long right = distance;
        long answer = 0;
        
        while (left <= right) {
            long mid = left + (right - left) / 2;  // 바위 사이의 최소 거리
            
            // 현재 위치
            int current = 0;
            // 제거한 바위 개수
            int removeCount = 0;
            
            // 각 바위를 순회하면서 제거할 바위 계산
            for (int rock : rocks) {
                // 현재 위치에서 바위까지의 거리
                if (rock - current < mid) {
                    // 거리가 mid보다 작으면 바위 제거
                    removeCount++;
                } else {
                    // 거리가 mid 이상이면 현재 위치 갱신
                    current = rock;
                }
            }
            
            // 마지막 지점까지의 거리 확인
            if (distance - current < mid) {
                removeCount++;
            }
            
            if (removeCount > n) {
                // 제거한 바위가 너무 많으면 거리를 줄임
                right = mid - 1;
            } else {
                // 제거한 바위가 n개 이하면 거리를 늘림
                answer = mid;
                left = mid + 1;
            }
        }
        
        return (int)answer;
    }
}