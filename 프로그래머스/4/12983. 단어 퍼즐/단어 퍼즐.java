import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        // 단어 조각들을 HashSet에 저장하여 검색 속도 향상
        HashSet<String> wordSet = new HashSet<>(Arrays.asList(strs));
        
        // dp[i] = t의 0~i까지의 부분 문자열을 만드는 데 필요한 최소 조각 개수
        int[] dp = new int[t.length() + 1];
        
        // 불가능한 경우를 표시하기 위한 큰 값
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        
        // 빈 문자열은 0개로 만들 수 있음
        dp[0] = 0;
        
        // 동적 프로그래밍으로 최소 조각 수 계산
        for (int i = 1; i <= t.length(); i++) {
            // 단어 조각의 최대 길이는 5이므로 최대 5글자까지만 확인
            for (int j = 1; j <= 5 && i - j >= 0; j++) {
                String piece = t.substring(i - j, i);
                if (wordSet.contains(piece)) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }
        
        // 불가능한 경우 -1 반환
        return dp[t.length()] < Integer.MAX_VALUE - 1 ? dp[t.length()] : -1;
    }
}