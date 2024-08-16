import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> participantMap = new HashMap<>();
        for (String name :
                participant) {
            participantMap.put(name, participantMap.getOrDefault(name,0) + 1);
        }
        for (String name :
                completion) {
            participantMap.put(name, participantMap.get(name) - 1);
        }
        for (Map.Entry<String, Integer> entry :
                participantMap.entrySet()) {
            if (entry.getValue() != 0){
                answer = entry.getKey();
            }
        }
        return answer;
    }
}