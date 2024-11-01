class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];
        int value = 1;
        int x = 0, y = 0;  // 현재 위치
        
        // 전체 채워야 할 숫자의 개수
        int total = n * (n + 1) / 2;
        
        while(value <= total) {
            // 아래로 이동
            while(x < n && triangle[x][y] == 0) {
                triangle[x++][y] = value++;
            }
            x--; y++; // 마지막 위치 조정
            
            // 오른쪽으로 이동
            while(y < n && triangle[x][y] == 0) {
                triangle[x][y++] = value++;
            }
            x--; y -= 2; // 마지막 위치 조정
            
            // 대각선 위로 이동
            while(x >= 0 && y >= 0 && triangle[x][y] == 0) {
                triangle[x--][y--] = value++;
            }
            x += 2; y++; // 마지막 위치 조정
        }
        
        // 결과 배열 생성
        int[] answer = new int[total];
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }
        
        return answer;
    }
}