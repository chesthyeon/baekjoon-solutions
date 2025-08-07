import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        // 1. 행렬 초기화
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = i * columns + j + 1;
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        
        // 2. 각 쿼리 처리
        for (int[] query : queries) {
            int x1 = query[0] - 1, y1 = query[1] - 1;
            int x2 = query[2] - 1, y2 = query[3] - 1;
            
            // 3. 테두리 회전 + 최솟값 찾기
            answer.add(rotateAndFindMin(matrix, x1, y1, x2, y2));
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    private int rotateAndFindMin(int[][] matrix, int x1, int y1, int x2, int y2) {
        // 테두리 좌표들 수집
        List<Integer> border = new ArrayList<>();
        
        // 위쪽 (왼->오)
        for (int j = y1; j < y2; j++) border.add(matrix[x1][j]);
        // 오른쪽 (위->아래)
        for (int i = x1; i < x2; i++) border.add(matrix[i][y2]);
        // 아래쪽 (오->왼)
        for (int j = y2; j > y1; j--) border.add(matrix[x2][j]);
        // 왼쪽 (아래->위)
        for (int i = x2; i > x1; i--) border.add(matrix[i][y1]);
        
        // 최솟값 찾기
        int min = Collections.min(border);
        
        // 시계방향 회전 (마지막 -> 맨 앞)
        border.add(0, border.remove(border.size() - 1));
        
        // 회전된 값들을 다시 배치
        int idx = 0;
        for (int j = y1; j < y2; j++) matrix[x1][j] = border.get(idx++);
        for (int i = x1; i < x2; i++) matrix[i][y2] = border.get(idx++);
        for (int j = y2; j > y1; j--) matrix[x2][j] = border.get(idx++);
        for (int i = x2; i > x1; i--) matrix[i][y1] = border.get(idx++);
        
        return min;
    }
}