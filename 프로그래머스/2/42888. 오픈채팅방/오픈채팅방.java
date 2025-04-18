import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> actionMap = new HashMap<>();
        actionMap.put("Enter", "님이 들어왔습니다.");
        actionMap.put("Leave", "님이 나갔습니다.");

        Map<String, String> userMap = new HashMap<>();
        for (String r : record) {
            String[] rParts = r.split(" ");
            if (rParts.length == 3) {
                userMap.put(rParts[1], rParts[2]);
            }
        }

        List<String> ans = new ArrayList<>();
        for (String r : record) {
            String[] rParts = r.split(" ");

            if (actionMap.containsKey(rParts[0])) {
                ans.add(userMap.get(rParts[1]) + actionMap.get(rParts[0]));
            }
        }
        
        return ans.toArray(new String[0]);
    }
}
