import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        // n이 너무 크면 메모리 초과 위험이 있음
        if (n > 1000) { // 적당한 임계값 설정
            return efficientSolution(n, left, right);
        }
        
        // 1. n x n 2차원 배열 생성
        int[][] matrix = new int[n][n];
        
        // 2. 배열 채우기
        for (int i = 1; i <= n; i++) {
            for (int r = 0; r < i; r++) {
                for (int c = 0; c < i; c++) {
                    if (matrix[r][c] == 0) {
                        matrix[r][c] = i;
                    }
                }
            }
        }
        
        // 3. 1차원 배열로 변환
        int[] flattened = new int[n * n];
        int index = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                flattened[index++] = matrix[r][c];
            }
        }
        
        // 4. left부터 right까지의 부분 배열 추출
        int[] result = new int[(int)(right - left) + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = flattened[(int)(left + i)];
        }
        
        return result;
    }
    
    // n이 큰 경우를 위한 효율적인 방법
    private int[] efficientSolution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];
        for (int i = 0; i < answer.length; i++) {
            int row = (int)(left / n);
            int col = (int)(left % n);
            answer[i] = Math.max(row + 1, col + 1);
            left++;
        }
        return answer;
    }
}