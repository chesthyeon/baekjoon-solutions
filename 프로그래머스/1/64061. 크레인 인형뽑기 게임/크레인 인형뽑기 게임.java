import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int size = board.length;  // 동적으로 크기 구하기
        Stack<Integer>[] stackArr = new Stack[size];
        
        for(int i = 0; i < stackArr.length; i++){
            stackArr[i] = new Stack();
        }
        
        for(int j = 0; j < size; j++){
            for(int i = size - 1; i >= 0; i--){
                if(board[i][j] == 0) continue;
                stackArr[j].push(board[i][j]);
            }
        }
        
        Stack<Integer> stack = new Stack();
        int ans = 0;
        
        for(int m : moves){
            if(stackArr[m - 1].isEmpty()) continue;
            int doll = stackArr[m - 1].pop();
            if(!stack.isEmpty() && stack.peek() == doll){
                stack.pop();
                ans += 2;
            } else {
                stack.push(doll);
            }
        }
        return ans;
    }
}