class Solution {
    public String solution(String number, int k) {
        StringBuilder result = new StringBuilder();
        int length = number.length() - k;
        int start = 0;
        
        while (length > 0) {
            char max = '0';
            int maxIdx = start;
            
            // 현재 위치부터 선택 가능한 범위 내에서 가장 큰 숫자 찾기
            for (int i = start; i <= number.length() - length; i++) {
                if (number.charAt(i) > max) {
                    max = number.charAt(i);
                    maxIdx = i;
                    // 9가 나오면 더 큰 숫자는 없으므로 바로 중단
                    if (max == '9') break;
                }
            }
            
            result.append(max);
            start = maxIdx + 1;
            length--;
        }
        
        return result.toString();
    }
}