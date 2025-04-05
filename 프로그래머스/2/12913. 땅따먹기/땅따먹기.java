import java.util.*;

class Solution {
    int solution(int[][] land) {
        int n = land.length;
        
        // 첫 번째 행은 초기값으로 사용
        // 두 번째 행부터 시작
        for (int i = 1; i < n; i++) {
            // 현재 행의 각 열을 순회
            for (int j = 0; j < 4; j++) {
                // 이전 행에서 현재 열을 제외한 최댓값을 찾아 더함
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (k != j && land[i-1][k] > max) {
                        max = land[i-1][k];
                    }
                }
                land[i][j] += max;
            }
        }
        
        // 마지막 행에서 최댓값 반환
        int maxScore = 0;
        for (int j = 0; j < 4; j++) {
            maxScore = Math.max(maxScore, land[n-1][j]);
        }
        
        return maxScore;
    }
}