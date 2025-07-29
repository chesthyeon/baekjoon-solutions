import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // 1. 사용자 ID별 최종 닉네임을 저장할 HashMap
        HashMap<String, String> userNicknames = new HashMap<>();
        
        // 2. 입장/퇴장 기록을 저장할 리스트 (Change는 제외)
        List<String[]> actions = new ArrayList<>();
        
        // 3. 1단계: 모든 기록을 처리하여 최종 닉네임 확정
        for (String log : record) {
            String[] parts = log.split(" ");
            String action = parts[0];  // Enter, Leave, Change
            String userId = parts[1];  // 사용자 ID
            
            if (action.equals("Enter") || action.equals("Change")) {
                String nickname = parts[2];  // 닉네임 (Leave에는 없음)
                // 사용자의 닉네임을 최신으로 업데이트
                userNicknames.put(userId, nickname);
            }
            
            // Enter와 Leave만 결과 생성 대상
            if (action.equals("Enter") || action.equals("Leave")) {
                actions.add(new String[]{action, userId});
            }
        }
        
        // 4. 2단계: 최종 닉네임을 적용하여 결과 메시지 생성
        List<String> result = new ArrayList<>();
        
        for (String[] actionInfo : actions) {
            String action = actionInfo[0];
            String userId = actionInfo[1];
            String finalNickname = userNicknames.get(userId);
            
            if (action.equals("Enter")) {
                result.add(finalNickname + "님이 들어왔습니다.");
            } else if (action.equals("Leave")) {
                result.add(finalNickname + "님이 나갔습니다.");
            }
        }
        
        // 5. List를 String 배열로 변환하여 반환
        return result.toArray(new String[result.size()]);
    }
}