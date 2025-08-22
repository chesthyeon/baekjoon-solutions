import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[9][9];
    static List<int[]> emptySpaces = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 받으면서 빈 칸 위치 저장
        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 0) {
                    emptySpaces.add(new int[]{i, j});
                }
            }
        }
        
        // 백트래킹으로 스도쿠 해결
        solve(0);
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    static boolean solve(int index) {
        // 모든 빈 칸을 다 채웠으면 완성!
        if (index == emptySpaces.size()) {
            return true;
        }
        
        int[] pos = emptySpaces.get(index);
        int row = pos[0], col = pos[1];
        
        // 1~9까지 숫자를 하나씩 시도
        for (int num = 1; num <= 9; num++) {
            if (isValid(row, col, num)) {
                board[row][col] = num;  // 숫자 배치
                
                if (solve(index + 1)) {  // 다음 빈 칸으로 재귀
                    return true;  // 성공하면 true 반환
                }
                
                board[row][col] = 0;  // 백트래킹 (원상복구)
            }
        }
        
        return false;  // 모든 숫자를 시도해도 안 되면 false
    }
    
    // 유효성 검사
    static boolean isValid(int row, int col, int num) {
        // 1. 행 검사
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }
        
        // 2. 열 검사  
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        
        // 3. 3×3 박스 검사
        int boxRow = (row / 3) * 3;  // 박스의 시작 행
        int boxCol = (col / 3) * 3;  // 박스의 시작 열
        
        for (int i = boxRow; i < boxRow + 3; i++) {
            for (int j = boxCol; j < boxCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        
        return true;  // 모든 검사 통과
    }
}