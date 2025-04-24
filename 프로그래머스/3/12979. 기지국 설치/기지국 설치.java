class Solution {
    public int solution(int n, int[] stations, int w) {
    int answer = 0;
    int position = 1; // 현재 검사 위치
    int idx = 0; // 기지국 배열 인덱스
    
    while (position <= n) {
        // 현재 위치가 기존 기지국 범위 안에 있는 경우
        if (idx < stations.length && position >= stations[idx] - w) {
            // 해당 기지국의 커버 범위를 벗어난 다음 위치로 이동
            position = stations[idx] + w + 1;
            idx++;
        } 
        // 현재 위치가 기존 기지국 범위 밖인 경우
        else {
            // 새 기지국을 설치하고 카운트 증가
            answer++;
            // 새 기지국의 커버 범위 다음 위치로 이동 (2*w+1은 한 기지국이 커버하는 범위)
            position += 2 * w + 1;
        }
    }
    
    return answer;
}
}