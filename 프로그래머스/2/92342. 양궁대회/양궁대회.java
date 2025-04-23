import java.util.Arrays;

class Solution {
    int maxDiff = -1;
    int[] result = null;
    
    public int[] solution(int n, int[] info) {
        // 라이언이 쏠 화살 배열
        int[] ryan = new int[11];
        
        // 백트래킹으로 모든 경우 탐색
        shoot(info, ryan, n, 0);
        
        // 라이언이 이길 수 없는 경우
        return result == null ? new int[]{-1} : result;
    }
    
    // idx: 현재 과녁 인덱스, arrows: 남은 화살 수
    private void shoot(int[] apeach, int[] ryan, int arrows, int idx) {
        // 모든 화살 사용 완료
        if (arrows == 0 || idx == 11) {
            // 남은 화살이 있으면 0점에 몰아줌
            if (arrows > 0) {
                ryan[10] += arrows;
            }
            
            // 점수 계산 후 최대값 갱신
            int diff = calculateScore(apeach, ryan);
            if (diff > 0 && diff >= maxDiff) {
                if (diff > maxDiff || isBetter(ryan, result)) {
                    maxDiff = diff;
                    result = ryan.clone();
                }
            }
            
            // 0점에 추가한 화살 초기화
            if (arrows > 0) {
                ryan[10] -= arrows;
            }
            return;
        }
        
        // 1. 현재 점수를 얻는 경우 (어피치보다 1발 더 쏨)
        if (arrows > apeach[idx]) {
            ryan[idx] = apeach[idx] + 1;
            shoot(apeach, ryan, arrows - ryan[idx], idx + 1);
            ryan[idx] = 0;
        }
        
        // 2. 현재 점수를 포기하는 경우 (안 쏨)
        shoot(apeach, ryan, arrows, idx + 1);
    }
    
    // 라이언과 어피치의 점수 차이 계산
    private int calculateScore(int[] apeach, int[] ryan) {
        int apeachScore = 0;
        int ryanScore = 0;
        
        for (int i = 0; i < 11; i++) {
            int point = 10 - i;
            if (apeach[i] == 0 && ryan[i] == 0) continue;
            
            if (apeach[i] >= ryan[i]) {
                apeachScore += point;
            } else {
                ryanScore += point;
            }
        }
        
        return ryanScore - apeachScore;
    }
    
    // 더 낮은 점수를 많이 맞힌 배열인지 확인
    private boolean isBetter(int[] ryan, int[] current) {
        if (current == null) return true;
        
        for (int i = 10; i >= 0; i--) {
            if (ryan[i] > current[i]) return true;
            if (ryan[i] < current[i]) return false;
        }
        return false;
    }
}