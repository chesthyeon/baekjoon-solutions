import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        // 1. 참가자들의 이름과 개수를 저장할 HashMap
        HashMap<String, Integer> participantMap = new HashMap<>();
        
        // 2. 참가자 명단을 HashMap에 저장 (이름별 개수 카운팅)
        for (String name : participant) participantMap.merge(name, 1, (a,b) -> a + b);
        
        // 3. 완주자 명단을 순회하면서 HashMap에서 개수 차감
        for (String name : completion) participantMap.merge(name, 1, (a,b) -> a - b);
        
        // 4. 개수가 1인 사람이 완주하지 못한 선수
        
        // 이론적으로 여기에 도달할 수 없음 (문제 조건상 반드시 1명 존재)
        return participantMap.entrySet().stream()
            .filter(entry -> entry.getValue() == 1)
            .map(entry -> entry.getKey())
            .findFirst()
            .orElse("");
    }
}