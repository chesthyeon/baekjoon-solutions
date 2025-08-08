import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        // words를 Set으로 변환 (빠른 검색)
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));
        if (!wordSet.contains(target)) return 0;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(begin);
        visited.add(begin);
        
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            // 현재 레벨의 모든 단어 처리
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                if (current.equals(target)) {
                    return steps;
                }
                
                // 한 글자씩 바꿔보며 변환 가능한 단어 찾기
                for (int j = 0; j < current.length(); j++) {
                    char[] chars = current.toCharArray();
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String newWord = new String(chars);
                        
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            queue.offer(newWord);
                        }
                    }
                }
            }
            
            steps++;
        }
        
        return 0;
    }
}