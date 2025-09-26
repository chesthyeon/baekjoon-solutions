import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportMap = new HashMap<>();
        for (String r : report) {
            String[] parts = r.split(" ");
            reportMap.computeIfAbsent(parts[1], key -> new HashSet<>()).add(parts[0]);
        }

        Map<String, Integer> id_map = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) id_map.put(id_list[i], i);

        int[] ans = new int[id_list.length];
        for (Map.Entry<String, Set<String>> stringSetEntry : reportMap.entrySet()) {
            Set<String> reportSet = stringSetEntry.getValue();
            if (reportSet.size() >= k) {
                for (String s : reportSet) {
                    ans[id_map.get(s)] += 1;
                }
            }
        }
        return ans;
    }
}
