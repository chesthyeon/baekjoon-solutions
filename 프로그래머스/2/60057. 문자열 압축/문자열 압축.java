public class Solution {
    public int solution(String s) {
        int minLen = s.length();
        
        // 압축 단위를 1부터 문자열 길이의 절반까지 시도
        for (int unit = 1; unit <= s.length() / 2; unit++) {
            int compressedLen = compress(s, unit);
            minLen = Math.min(minLen, compressedLen);
        }
        
        return minLen;
    }
    
    // 주어진 단위로 문자열을 압축했을 때의 길이를 계산
    private int compress(String s, int unit) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i += unit) {
            // 현재 압축 단위만큼 문자열 추출
            String current = s.substring(i, Math.min(i + unit, s.length()));
            int count = 1;
            
            // 연속된 같은 문자열 개수 세기
            while (i + unit * count < s.length()) {
                String next = s.substring(i + unit * count, 
                    Math.min(i + unit * (count + 1), s.length()));
                if (current.equals(next) && next.length() == unit) {
                    count++;
                } else {
                    break;
                }
            }
            
            // 결과에 추가
            if (count > 1) {
                result.append(count);
            }
            result.append(current);
            
            // 다음 위치로 이동 (연속된 문자열만큼 건너뛰기)
            i += unit * (count - 1);
        }
        
        return result.length();
    }
    
    // 테스트용 메인 메서드
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        // 테스트 케이스
        System.out.println(sol.solution("aabbaccc")); // 7
        System.out.println(sol.solution("ababcdcdababcdcd")); // 9
        System.out.println(sol.solution("abcabcdede")); // 8
        System.out.println(sol.solution("abcabcabcabcdededededede")); // 14
        System.out.println(sol.solution("xababcdcdababcdcd")); // 17
    }
}