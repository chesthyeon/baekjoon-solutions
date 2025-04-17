import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        
        for (int move : moves) {
            int column = move - 1; // 0-based 인덱스로 변환
            
            // 해당 열에서 가장 위에 있는 인형 찾기
            for (int row = 0; row < board.length; row++) {
                if (board[row][column] != 0) {
                    int doll = board[row][column];
                    board[row][column] = 0; // 인형 집어올림
                    
                    // 바구니에 같은 인형이 있으면 터트림
                    if (!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop();
                        answer += 2; // 인형 2개가 사라짐
                    } else {
                        basket.push(doll);
                    }
                    
                    break; // 인형을 하나 집었으면 다음 move로
                }
            }
        }
        
        return answer;
    }
}