import java.util.*;

public class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 총 재생횟수와 곡 정보 수집
        Map<String, Integer> genreTotal = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            genreTotal.put(genre, genreTotal.getOrDefault(genre, 0) + play);
            genreSongs.computeIfAbsent(genre, k -> new ArrayList<>()).add(new int[]{i, play});
        }
        
        // 2. 장르를 총 재생횟수로 정렬
        List<String> sortedGenres = new ArrayList<>(genreTotal.keySet());
        sortedGenres.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));
        
        // 3. 각 장르에서 최대 2곡씩 선택
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songs = genreSongs.get(genre);
            
            // 재생횟수 내림차순, 인덱스 오름차순 정렬
            songs.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
            
            // 최대 2곡 선택
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i)[0]);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}