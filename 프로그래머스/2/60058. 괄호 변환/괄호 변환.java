class Solution {
    public String solution(String p) {
        return convert(p);
    }
    
    private String convert(String s) {
        if (s.isEmpty()) return "";
        
        // u, v 분리
        int idx = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += (s.charAt(i) == '(') ? 1 : -1;
            if (count == 0) {
                idx = i + 1;
                break;
            }
        }
        
        String u = s.substring(0, idx);
        String v = s.substring(idx);
        
        // u가 올바른 괄호인지 확인
        if (isCorrect(u)) {
            return u + convert(v);
        }
        
        // u가 올바르지 않은 경우
        String result = "(" + convert(v) + ")";
        
        // u의 첫번째, 마지막 제거 후 나머지 뒤집기
        for (int i = 1; i < u.length() - 1; i++) {
            result += (u.charAt(i) == '(') ? ')' : '(';
        }
        
        return result;
    }
    
    private boolean isCorrect(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            count += (c == '(') ? 1 : -1;
            if (count < 0) return false;
        }
        return true;
    }
}