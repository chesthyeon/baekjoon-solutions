class Solution {
    public int solution(String name) {
        // 상하 이동 계산
        int upDown = 0;
        for (char c : name.toCharArray()) {
            upDown += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        // 좌우 이동 계산
        int len = name.length();
        int leftRight = len - 1; // 기본적으로 오른쪽으로 쭉 이동
        
        for (int i = 0; i < len; i++) {
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            
            // min(정방향으로 i까지 + 뒤로 돌아와 끝에서 next까지, 처음부터 뒤로 돌아가서 next까지 + 다시 앞으로 와서 i까지)
            int move = i + (len - next) + Math.min(i, len - next);
            leftRight = Math.min(leftRight, move);
        }
        
        return upDown + leftRight;
    }
}