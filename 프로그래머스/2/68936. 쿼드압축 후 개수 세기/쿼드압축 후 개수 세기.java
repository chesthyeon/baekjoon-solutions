class Solution {
    int[] answer = new int[2]; // [0의 개수, 1의 개수]
    
    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }
    
    private void compress(int[][] arr, int x, int y, int size) {
        // 모든 값이 같은지 확인
        if (isAllSame(arr, x, y, size)) {
            answer[arr[x][y]] += 1; // 값이 0이면 answer[0]에, 1이면 answer[1]에 추가
            return;
        }
        
        // 4등분으로 나누어 재귀 호출
        int newSize = size / 2;
        compress(arr, x, y, newSize);                     // 좌상단
        compress(arr, x, y + newSize, newSize);           // 우상단
        compress(arr, x + newSize, y, newSize);           // 좌하단
        compress(arr, x + newSize, y + newSize, newSize); // 우하단
    }
    
    private boolean isAllSame(int[][] arr, int x, int y, int size) {
        int value = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != value) {
                    return false;
                }
            }
        }
        return true;
    }
}