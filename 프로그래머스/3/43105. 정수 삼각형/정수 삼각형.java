class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        
        // DP 배열 생성 - triangle 배열을 직접 수정하여 공간 절약
        // triangle[i][j]는 해당 위치까지의 최대 합을 저장
        for (int i = 1; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) { // 왼쪽 끝
                    triangle[i][j] += triangle[i-1][j];
                }
                else if (j == i) { // 오른쪽 끝
                    triangle[i][j] += triangle[i-1][j-1];
                }
                else { // 중간 위치
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }
        
        // 마지막 행에서 최대값 찾기
        int maxSum = 0;
        for (int num : triangle[height-1]) {
            maxSum = Math.max(maxSum, num);
        }
        
        return maxSum;
    }
}