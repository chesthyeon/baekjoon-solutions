class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        // 1부터 문자열 길이의 절반까지 단위로 압축 시도
        for (int unit = 1; unit <= s.length() / 2; unit++) {
            String prev = s.substring(0, unit);
            int count = 1;
            StringBuilder compressed = new StringBuilder();
            
            // unit 단위로 문자열 비교
            for (int i = unit; i <= s.length() - unit; i += unit) {
                String current = s.substring(i, i + unit);
                
                if (prev.equals(current)) {
                    count++;
                } else {
                    // 반복된 문자열 처리
                    if (count > 1) compressed.append(count);
                    compressed.append(prev);
                    prev = current;
                    count = 1;
                }
            }
            
            // 마지막 문자열 처리
            if (count > 1) compressed.append(count);
            compressed.append(prev);
            
            // 나누어 떨어지지 않는 나머지 문자열 처리
            int remain = s.length() % unit;
            if (remain > 0) {
                compressed.append(s.substring(s.length() - remain));
            }
            
            // 최소 길이 업데이트
            answer = Math.min(answer, compressed.length());
        }
        
        return answer;
    }
}