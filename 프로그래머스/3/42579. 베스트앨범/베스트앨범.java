import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수를 저장할 Map
        Map<String, Integer> genrePlayCount = new HashMap<>();
        // 장르별 노래 정보(인덱스, 재생 횟수)를 저장할 Map
        Map<String, List<int[]>> genreSongs = new HashMap<>();
        
        // 데이터 처리
        for (int i = 0; i < genres.length; i++) {
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);
            genreSongs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new int[]{i, plays[i]});
        }
        
        // 장르를 총 재생 횟수 기준으로 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));
        
        List<Integer> answer = new ArrayList<>();
        
        // 장르별로 노래 선택
        for (String genre : sortedGenres) {
            List<int[]> songs = genreSongs.get(genre);
            songs.sort((a, b) -> b[1] - a[1]); // 재생 횟수로 정렬
            
            answer.add(songs.get(0)[0]); // 가장 많이 재생된 노래 추가
            if (songs.size() > 1) {
                answer.add(songs.get(1)[0]); // 두 번째로 많이 재생된 노래 추가
            }
        }
        
        // List를 배열로 변환
        return answer.stream().mapToInt(i -> i).toArray();
    }
}