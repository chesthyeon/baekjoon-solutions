import java.util.*;

class Solution {
    class Puzzle {
        List<int[]> blocks;  // 퍼즐 조각의 좌표들
        int size;           // 퍼즐 크기
        
        public Puzzle() {
            blocks = new ArrayList<>();
        }
        
        // 좌표를 원점 기준으로 변환
        public void normalize() {
            if (blocks.isEmpty()) return;
            
            int minX = blocks.get(0)[0];
            int minY = blocks.get(0)[1];
            
            // 최소 x, y 값 찾기
            for (int[] block : blocks) {
                minX = Math.min(minX, block[0]);
                minY = Math.min(minY, block[1]);
            }
            
            // 모든 좌표를 원점 기준으로 이동
            for (int[] block : blocks) {
                block[0] -= minX;
                block[1] -= minY;
            }
            
            size = blocks.size();
        }
        
        // 90도 회전
        public void rotate() {
            for (int[] block : blocks) {
                int temp = block[0];
                block[0] = block[1];
                block[1] = -temp;
            }
            normalize();
        }
        
        // 다른 퍼즐과 비교
        public boolean equals(Puzzle other) {
            if (this.size != other.size) return false;
            
            for (int rot = 0; rot < 4; rot++) {
                boolean match = true;
                for (int[] block : blocks) {
                    boolean foundMatch = false;
                    for (int[] otherBlock : other.blocks) {
                        if (block[0] == otherBlock[0] && block[1] == otherBlock[1]) {
                            foundMatch = true;
                            break;
                        }
                    }
                    if (!foundMatch) {
                        match = false;
                        break;
                    }
                }
                if (match) return true;
                other.rotate();
            }
            return false;
        }
    }
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n;
    
    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        int answer = 0;
        
        // 빈 자리 퍼즐들을 찾아 리스트에 저장
        List<Puzzle> emptyPuzzles = new ArrayList<>();
        boolean[][] visitedBoard = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visitedBoard[i][j] && game_board[i][j] == 0) {
                    Puzzle puzzle = findPuzzle(game_board, visitedBoard, i, j, 0);
                    puzzle.normalize();
                    emptyPuzzles.add(puzzle);
                }
            }
        }
        
        // 테이블의 퍼즐들을 찾아 리스트에 저장
        List<Puzzle> tablePuzzles = new ArrayList<>();
        boolean[][] visitedTable = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visitedTable[i][j] && table[i][j] == 1) {
                    Puzzle puzzle = findPuzzle(table, visitedTable, i, j, 1);
                    puzzle.normalize();
                    tablePuzzles.add(puzzle);
                }
            }
        }
        
        // 각 빈 자리에 맞는 퍼즐 찾기
        boolean[] used = new boolean[tablePuzzles.size()];
        
        for (Puzzle emptyPuzzle : emptyPuzzles) {
            for (int i = 0; i < tablePuzzles.size(); i++) {
                if (used[i]) continue;
                
                if (emptyPuzzle.equals(tablePuzzles.get(i))) {
                    answer += emptyPuzzle.size;
                    used[i] = true;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    private Puzzle findPuzzle(int[][] board, boolean[][] visited, int x, int y, int target) {
        Puzzle puzzle = new Puzzle();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        puzzle.blocks.add(new int[]{x, y});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < n 
                    && !visited[nx][ny] && board[nx][ny] == target) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    puzzle.blocks.add(new int[]{nx, ny});
                }
            }
        }
        
        return puzzle;
    }
}