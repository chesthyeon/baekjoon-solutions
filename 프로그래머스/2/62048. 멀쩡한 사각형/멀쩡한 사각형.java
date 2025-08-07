class Solution {
     public long solution(int w, int h) {
        // 전체 사각형 개수
        long totalSquares = (long) w * h;
        
        // 대각선에 의해 손상된 사각형 개수
        long damagedSquares = w + h - gcd(w, h);
        
        // 멀쩡한 사각형 개수 = 전체 - 손상된 것들
        return totalSquares - damagedSquares;
    }
    
    /**
     * 유클리드 호제법으로 최대공약수 구하기
     * gcd(a, b) = gcd(b, a % b)
     */
    private long gcd(long a, long b) {
        // 재귀 방식
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}