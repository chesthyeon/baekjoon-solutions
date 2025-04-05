import java.util.*;

public class Solution {
    public int solution(String[] strs, String t) {
        // Set으로 단어 조각들 저장 (검색 O(1) 시간복잡도)
        Set<String> wordSet = new HashSet<>(Arrays.asList(strs));
        int n = t.length();
        
        // dp[i] = t의 0~i까지 문자열을 만드는 최소 조각 수
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1); // 오버플로우 방지를 위해 -1
        dp[0] = 0; // 빈 문자열은 0개로 만들 수 있음
        
        // 각 위치까지의 최소 조각 수 계산
        for (int end = 1; end <= n; end++) {
            // 가능한 모든 시작점 탐색 (최대 단어 길이 제한)
            for (int start = Math.max(0, end - 5); start < end; start++) {
                String piece = t.substring(start, end);
                // 해당 조각이 있는지 확인하고 DP 갱신
                if (wordSet.contains(piece)) {
                    dp[end] = Math.min(dp[end], dp[start] + 1);
                }
            }
        }
        
        return dp[n] < Integer.MAX_VALUE - 1 ? dp[n] : -1;
    }
}