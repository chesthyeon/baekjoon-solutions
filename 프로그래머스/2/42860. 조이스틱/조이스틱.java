class Solution {
    public int solution(String name) {
        int n = name.length();
        
        // 1. 상하 조작 횟수 계산
        int upDown = 0;
        for (char c : name.toCharArray()) {
            // A에서 목표 문자까지의 최소 조작 횟수
            upDown += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        // 2. 좌우 이동 횟수 최적화
        int minMove = n - 1; // 기본: 처음부터 끝까지 순차 이동
        
        for (int i = 0; i < n; i++) {
            // i번째 문자 다음부터 연속된 A의 끝 지점 찾기
            int nextPos = i + 1;
            while (nextPos < n && name.charAt(nextPos) == 'A') {
                nextPos++;
            }
            
            // 여러 이동 패턴 중 최소값 계산
            
            // 패턴 1: 순차적으로 오른쪽 이동 (기존 minMove)
            
            // 패턴 2: i까지 가고 돌아와서 끝에서부터 nextPos까지
            // 0 → i → 0 → (n-1) → ... → nextPos
            int pattern2 = i * 2 + (n - nextPos);
            
            // 패턴 3: 끝에서부터 nextPos까지 가고 돌아와서 i까지  
            // 0 → (n-1) → ... → nextPos → (n-1) → 0 → ... → i
            int pattern3 = (n - nextPos) * 2 + i;
            
            minMove = Math.min(minMove, Math.min(pattern2, pattern3));
        }
        
        return upDown + minMove;
    }
}