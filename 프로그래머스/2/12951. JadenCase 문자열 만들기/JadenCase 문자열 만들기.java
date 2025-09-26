class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;  // 단어의 첫 글자인지 확인
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
                isFirst = true;  // 다음 문자는 단어의 첫 글자
            } else {
                if (isFirst && Character.isLetter(c)) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                isFirst = false;
            }
        }
        
        return sb.toString();
    }
}