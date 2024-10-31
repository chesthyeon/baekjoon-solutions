class Solution {
    public String solution(String number, int k) {
        StringBuilder result = new StringBuilder();
        int length = number.length() - k; // 최종적으로 만들어야 하는 길이
        int start = 0;
        while (length > 0) {
            int end = number.length() - length + 1;
            char max = '0';
            int maxIdx = start;
            for (int i = start; i < end; i++){
                if (number.charAt(i) > max){
                    max = number.charAt(i);
                    maxIdx = i;
                }
            }
            result.append(max);
            start = maxIdx + 1;
            length--;
        }
        return result.toString();
    }
}