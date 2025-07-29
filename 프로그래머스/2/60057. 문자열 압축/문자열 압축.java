class Solution {
    public int solution(String s) {
        int minLen = s.length();

        // 1개 단위부터 문자열 길이/2까지 시도
        for (int unit = 1; unit <= s.length() / 2; unit++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, unit);
            int count = 1;

            // unit 길이씩 잘라서 비교
            for (int i = unit; i < s.length(); i += unit) {
                String curr = "";
                if (i + unit <= s.length()) {
                    curr = s.substring(i, i + unit);
                } else {
                    curr = s.substring(i);
                }

                if (prev.equals(curr) && curr.length() == unit) {
                    count++;
                } else {
                    // 압축 결과에 추가
                    if (count > 1) sb.append(count);
                    sb.append(prev);

                    prev = curr;
                    count = 1;
                }
            }

            // 마지막 부분 처리
            if (count > 1) sb.append(count);
            sb.append(prev);

            minLen = Math.min(minLen, sb.length());
        }

        return minLen;
    }
}