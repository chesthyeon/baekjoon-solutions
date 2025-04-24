class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
    long answer = 0;
    int dCap = 0, pCap = 0;
    
    // 가장 먼 집부터 역순으로 처리
    for (int i = n - 1; i >= 0; i--) {
        // 배달과 수거 용량 업데이트
        dCap += deliveries[i];
        pCap += pickups[i];
        
        // 배달이나 수거해야 할 물품이 용량을 초과하면 여러 번 방문해야 함
        while (dCap > 0 || pCap > 0) {
            dCap -= cap;
            pCap -= cap;
            answer += (i + 1) * 2; // i+1번 집까지의 왕복 거리
        }
    }
    
    return answer;
}
}