import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> wordSets = new HashSet<>();
        wordSets.add(words[0]);
        char pre = words[0].charAt(words[0].length() - 1);
        int[] ans = new int[2];
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
            char cur = word.charAt(0);
            if (wordSets.contains(word) || pre != cur) {
                ans[0] = i % n + 1;
                ans[1] = i / n + 1;
                return ans;
            } else {
                wordSets.add(word);
                pre = word.charAt(word.length() - 1);
            }
        }
        return ans;
    }
}