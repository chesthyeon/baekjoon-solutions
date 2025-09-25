import java.util.*;
import java.util.stream.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
         int r1 = arr1.length;
        int c1 = arr1[0].length;
        int r2 = arr2.length;
        int c2 = arr2[0].length;

        // ❷ 결과를 저장할 2차원 배열 초기화
        int[][] answer = new int[r1][c2];
        
         for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                // ❹ 두 행렬의 데이터를 곱해 결과 리스트에 더해줌
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
                                                        
        return answer;
    }
}