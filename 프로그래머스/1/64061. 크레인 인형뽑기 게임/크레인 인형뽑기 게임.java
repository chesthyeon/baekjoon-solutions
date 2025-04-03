import java.util.ArrayDeque;
import java.util.Stack;
import java.util.stream.IntStream;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        
        // 각 열에 대한 스택 생성
        ArrayDeque<Integer>[] lanes = IntStream.range(0, n)
            .mapToObj(i -> new ArrayDeque<Integer>())
            .toArray(ArrayDeque[]::new);
        
        // board를 역순으로 탐색하며 각 열의 인형을 lanes에 추가
        IntStream.range(0, n)
            .map(i -> n - 1 - i)
            .forEach(i -> IntStream.range(0, n)
                .filter(j -> board[i][j] > 0)
                .forEach(j -> lanes[j].addFirst(board[i][j])));
        
        // 인형을 담을 바구니와 결과 값 초기화
        Stack<Integer> bucket = new Stack<>();
        int[] answer = {0}; // 람다에서 수정 가능하도록 배열로 선언
        
        // moves 배열을 순회하며 인형 이동
        IntStream.of(moves)
            .map(move -> move - 1) // 인덱스는 0부터 시작하므로 -1
            .forEach(move -> {
                if (!lanes[move].isEmpty()) {
                    int doll = lanes[move].removeFirst();
                    
                    if (!bucket.isEmpty() && bucket.peek() == doll) {
                        bucket.pop();
                        answer[0] += 2; // 인형 두 개가 사라짐
                    } else {
                        bucket.push(doll);
                    }
                }
            });
        
        return answer[0];
    }
}