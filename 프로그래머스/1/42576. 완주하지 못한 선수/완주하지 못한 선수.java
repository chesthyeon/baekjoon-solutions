import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        for (String p : completion) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        for (String p : participant) {
            if (map.getOrDefault(p, 0) == 0) {
                return p;
            } else {
                map.put(p, map.get(p) - 1);
            }
        }
        return answer;
    }
}
