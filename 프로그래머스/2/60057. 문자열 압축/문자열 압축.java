class Solution {
    public int solution(String s) {
        int answer = s.length(); // 압축하지 않았을 때의 길이로 초기화
        
        // 1개 단위부터 문자열 길이의 절반까지 압축 시도
        for(int unit = 1; unit <= s.length()/2; unit++) {
            int compressedLength = compress(s, unit);
            answer = Math.min(answer, compressedLength);
        }
        
        return answer;
    }
    
    private int compress(String s, int unit) {
        StringBuilder compressed = new StringBuilder();
        String prev = s.substring(0, unit); // 이전 문자열
        int count = 1; // 현재 문자열의 반복 횟수
        
        // unit 크기만큼 문자열을 잘라가며 비교
        for(int i = unit; i <= s.length() - unit; i += unit) {
            String current = s.substring(i, i + unit);
            
            if(prev.equals(current)) {
                count++;
            } else {
                // 반복된 문자열 처리
                if(count > 1) {
                    compressed.append(count);
                }
                compressed.append(prev);
                prev = current;
                count = 1;
            }
        }
        
        // 마지막 문자열 처리
        if(count > 1) {
            compressed.append(count);
        }
        compressed.append(prev);
        
        // 남은 문자열 처리 (unit으로 나누어떨어지지 않는 경우)
        int remain = s.length() % unit;
        if(remain > 0) {
            compressed.append(s.substring(s.length() - remain));
        }
        
        return compressed.length();
    }
}