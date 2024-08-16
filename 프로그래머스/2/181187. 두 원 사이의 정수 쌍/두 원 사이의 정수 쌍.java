class Solution {
    public long solution(int r1, int r2) {
        long count = 0;
        
        for (int x = 0; x <= r2; x++) {
            double y2 = Math.floor(Math.sqrt((long)r2 * r2 - (long)x * x));
            double y1 = Math.ceil(Math.sqrt(Math.max(0, (long)r1 * r1 - (long)x * x)));
            
            count += (long)(y2 - y1 + 1);
        }
        
        return count * 4 - (r2 - r1 + 1) * 4;
    }
}