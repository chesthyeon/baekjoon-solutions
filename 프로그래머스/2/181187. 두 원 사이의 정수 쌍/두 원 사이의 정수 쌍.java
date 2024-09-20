class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        
        for (int x = 0; x <= r2; x++) {
            long y1 = (long) Math.ceil(Math.sqrt((long)r1 * r1 - (long)x * x));
            long y2 = (long) Math.floor(Math.sqrt((long)r2 * r2 - (long)x * x));
            
            if (x <= r1) {
                answer += (y2 - y1 + 1);
            } else {
                answer += (y2 + 1);
            }
        }
        
        return answer * 4 - 4 * (r2 - r1 + 1);
    }
}