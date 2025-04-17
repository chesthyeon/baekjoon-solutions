import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 삭제된 행 인덱스를 저장할 스택
        Stack<Integer> deleted = new Stack<>();
        
        // 링크드 리스트 구현을 위한 이전/다음 포인터 배열
        // 인덱스는 1부터 시작하도록 설정 (경계 처리 편의성)
        int[] prev = new int[n + 2];
        int[] next = new int[n + 2];
        
        // 링크드 리스트 초기화
        for (int i = 0; i <= n; i++) {
            prev[i + 1] = i;
            next[i] = i + 1;
        }
        
        // 현재 커서 위치 (1-indexed)
        int cursor = k + 1;
        
        // 명령 처리
        for (String command : cmd) {
            char type = command.charAt(0);
            
            switch (type) {
                case 'U': // 위로 이동
                    int upCount = Integer.parseInt(command.substring(2));
                    for (int i = 0; i < upCount; i++) {
                        cursor = prev[cursor];
                    }
                    break;
                    
                case 'D': // 아래로 이동
                    int downCount = Integer.parseInt(command.substring(2));
                    for (int i = 0; i < downCount; i++) {
                        cursor = next[cursor];
                    }
                    break;
                    
                case 'C': // 현재 행 삭제
                    deleted.push(cursor - 1); // 0-indexed로 변환하여 저장
                    
                    // 링크드 리스트에서 현재 행 제거
                    prev[next[cursor]] = prev[cursor];
                    next[prev[cursor]] = next[cursor];
                    
                    // 커서 이동 (마지막 행이었다면 이전 행으로, 아니면 다음 행으로)
                    cursor = (next[cursor] > n) ? prev[cursor] : next[cursor];
                    break;
                    
                case 'Z': // 최근 삭제된 행 복구
                    int restore = deleted.pop() + 1; // 1-indexed로 변환
                    
                    // 링크드 리스트에 복구
                    next[prev[restore]] = restore;
                    prev[next[restore]] = restore;
                    break;
            }
        }
        
        // 결과 문자열 생성
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append('O');
        }
        
        // 삭제된 행 표시
        while (!deleted.isEmpty()) {
            answer.setCharAt(deleted.pop(), 'X');
        }
        
        return answer.toString();
    }
}