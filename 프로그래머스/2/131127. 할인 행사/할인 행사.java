import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        for (int i = 0; i <= discount.length - 10; i++) {
            HashMap<String, Integer> map2 = new HashMap<>();
            for(int j = i; j < i + 10; j++) {
               if (map.containsKey(discount[j])) {
                   map2.put(discount[j], map2.getOrDefault(discount[j],0) + 1);
               }
            }
            if (map.equals(map2)) {
                answer++;
            }
        }
        return answer;
    }
}
