import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        // 각 banned_id에 맞는 user_id의 목록을 저장
        List<List<String>> matchingIds = new ArrayList<>();
        
        // 각 banned_id마다 매칭되는 user_id 찾기
        for (String pattern : banned_id) {
            List<String> matches = new ArrayList<>();
            for (String userId : user_id) {
                if (isMatch(userId, pattern)) {
                    matches.add(userId);
                }
            }
            matchingIds.add(matches);
        }
        
        // 중복을 제거할 집합
        Set<Set<String>> result = new HashSet<>();
        
        // DFS로 가능한 모든 조합 찾기
        findCombinations(matchingIds, new HashSet<>(), 0, result);
        
        return result.size();
    }
    
    // userId가 패턴과 일치하는지 확인
    private boolean isMatch(String userId, String pattern) {
        if (userId.length() != pattern.length()) {
            return false;
        }
        
        for (int i = 0; i < userId.length(); i++) {
            if (pattern.charAt(i) != '*' && pattern.charAt(i) != userId.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    // DFS로 가능한 모든 조합 찾기
    private void findCombinations(List<List<String>> matchingIds, Set<String> current, int index, Set<Set<String>> result) {
        // 모든 banned_id를 처리했으면 결과에 추가
        if (index == matchingIds.size()) {
            result.add(new HashSet<>(current));
            return;
        }
        
        // 현재 banned_id에 맞는 user_id를 하나씩 선택
        for (String id : matchingIds.get(index)) {
            // 이미 선택된 ID는 건너뛰기
            if (!current.contains(id)) {
                current.add(id);
                findCombinations(matchingIds, current, index + 1, result);
                current.remove(id);
            }
        }
    }
}