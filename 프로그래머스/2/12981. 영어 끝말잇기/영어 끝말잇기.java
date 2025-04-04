import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();
        
        // 첫 단어 처리
        usedWords.add(words[0]);
        
        for (int i = 1; i < words.length; i++) {
            String prevWord = words[i-1];
            String currentWord = words[i];
            
            char lastCharOfPrev = prevWord.charAt(prevWord.length() - 1);
            char firstCharOfCurrent = currentWord.charAt(0);
            
            // 탈락 조건 확인: 이미 사용된 단어이거나 끝말잇기 규칙을 어긴 경우
            if (usedWords.contains(currentWord) || lastCharOfPrev != firstCharOfCurrent) {
                // 탈락자 번호: (i % n) + 1, 탈락자 차례: (i / n) + 1
                return new int[] {(i % n) + 1, (i / n) + 1};
            }
            
            usedWords.add(currentWord);
        }
        
        // 탈락자가 없는 경우
        return new int[] {0, 0};
    }
}