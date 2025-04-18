import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> nameCnt = new HashMap();

        for (String p : participant) {
            nameCnt.put(p, nameCnt.getOrDefault(p, 0) + 1);
        }

        for (String c : completion) {
            int cnt = nameCnt.get(c);
            if (cnt == 1) {
                nameCnt.remove(c);
            } else {
                nameCnt.put(c, cnt - 1);
            }
        }
        return nameCnt.keySet().iterator().next();
    }
}
