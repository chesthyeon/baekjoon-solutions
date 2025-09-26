import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();
        usedWords.add(words[0]);
        
        char lastChar = words[0].charAt(words[0].length() - 1);
        
        for (int i = 1; i < words.length; i++) {
            String currentWord = words[i];
            char firstChar = currentWord.charAt(0);
            
            // 탈락 조건 체크
            if (usedWords.contains(currentWord) || lastChar != firstChar) {
                return new int[]{i % n + 1, i / n + 1};
            }
            
            // 다음 라운드 준비
            usedWords.add(currentWord);
            lastChar = currentWord.charAt(currentWord.length() - 1);
        }
        
        return new int[]{0, 0};  // 탈락자 없음
    }
}