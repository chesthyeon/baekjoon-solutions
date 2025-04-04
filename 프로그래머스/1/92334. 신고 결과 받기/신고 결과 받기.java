import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> id_map = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            id_map.put(id_list[i], i);
        }

        HashMap<String, HashSet<String>> map = new HashMap<>();
        Arrays.stream(id_list).forEach(id ->  map.put(id, new HashSet<>()));

        Arrays.stream(report).forEach(s -> {
            String[] split = s.split(" ");
            map.get(split[1]).add(split[0]);
        });

        int[] answer = new int[id_list.length];

        map.forEach((s, hashSet) -> {
            if (hashSet.size() >= k) {
                for (String reporter : hashSet) {
                    answer[id_map.get(reporter)]++;
                }
            }
        });
        return answer;
    }
}
