import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        // 파일명을 HEAD, NUMBER, TAIL로 분리하여 정렬
        Arrays.sort(files, (o1, o2) -> {
            // HEAD 추출 (숫자가 나오기 전까지의 문자열)
            String head1 = o1.split("[0-9]")[0].toLowerCase();
            String head2 = o2.split("[0-9]")[0].toLowerCase();
            
            // HEAD 비교
            int headCompare = head1.compareTo(head2);
            if (headCompare != 0) {
                return headCompare;
            }
            
            // NUMBER 추출 (처음 나오는 숫자들)
            String num1 = extractNumber(o1.substring(head1.length()));
            String num2 = extractNumber(o2.substring(head2.length()));
            
            // NUMBER 비교 (숫자 값으로)
            return Integer.parseInt(num1) - Integer.parseInt(num2);
        });
        
        return files;
    }
    
    // 문자열에서 처음 나오는 숫자 부분만 추출
    private String extractNumber(String str) {
        StringBuilder num = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) && num.length() < 5) {
                num.append(c);
            } else if (!Character.isDigit(c) && num.length() > 0) {
                break;
            }
        }
        return num.toString();
    }
}