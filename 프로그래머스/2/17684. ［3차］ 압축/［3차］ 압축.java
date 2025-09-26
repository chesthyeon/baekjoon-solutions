import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dictionary = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            dictionary.put("" + (char)('A' + i), 1 + i);
        }

        StringBuilder pre = new StringBuilder();
        ArrayList<Integer> ans = new ArrayList<>();
        int num = 27;

        for (char m : msg.toCharArray()) {
            StringBuilder cur = new StringBuilder(pre).append(m);
            if (dictionary.containsKey(cur.toString())) {
                pre = cur;
            } else {
                ans.add(dictionary.get(pre.toString()));
                dictionary.put(cur.toString(), num++);
                pre = new StringBuilder().append(m);
            }
        }
        ans.add(dictionary.get(pre.toString()));
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}