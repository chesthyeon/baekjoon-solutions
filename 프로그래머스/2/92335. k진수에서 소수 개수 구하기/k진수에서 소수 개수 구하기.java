class Solution {
    public int solution(int n, int k) {
        // n을 k진수로 변환하고 0으로 분할
        String[] parts = Integer.toString(n, k).split("0");
        
        int count = 0;
        for (String part : parts) {
            // 숫자가 있고 소수인 경우 카운트 증가
            if (!part.isEmpty() && isPrime(Long.parseLong(part))) {
                count++;
            }
        }
        return count;
    }
    
    // 소수 판별 함수
    private boolean isPrime(long num) {
        // 1은 소수가 아님
        if (num <= 1) return false;
        
        // 2와 3은 소수
        if (num <= 3) return true;
        
        // 2로 나누어지면 소수가 아님
        if (num % 2 == 0) return false;
        
        // 3부터 제곱근까지 홀수로만 나눗셈 시도
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}