import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수를 저장할 맵
        Map<String, Integer> genreTotalPlays = new HashMap<>();
        // 장르별 노래 정보(인덱스, 재생 횟수)를 저장할 맵
        Map<String, List<Song>> genreSongs = new HashMap<>();
        
        // 데이터 처리
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            // 장르별 총 재생 횟수 누적
            genreTotalPlays.put(genre, genreTotalPlays.getOrDefault(genre, 0) + play);
            
            // 장르별 노래 정보 저장
            genreSongs.computeIfAbsent(genre, k -> new ArrayList<>())
                      .add(new Song(i, play));
        }
        
        // 결과를 저장할 리스트
        List<Integer> answer = new ArrayList<>();
        
        // 장르를 총 재생 횟수로 정렬 (내림차순)
        genreTotalPlays.entrySet().stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .forEach(entry -> {
                String genre = entry.getKey();
                List<Song> songs = genreSongs.get(genre);
                
                // 장르 내에서 노래를 재생 횟수로 정렬 (내림차순), 같으면 인덱스로 정렬 (오름차순)
                songs.sort((s1, s2) -> {
                    if (s1.plays == s2.plays) {
                        return s1.index - s2.index; // 재생 횟수 같으면 인덱스 오름차순
                    }
                    return s2.plays - s1.plays; // 재생 횟수 내림차순
                });
                
                // 최대 2곡까지 선택
                answer.add(songs.get(0).index); // 가장 많이 재생된 노래
                if (songs.size() > 1) {
                    answer.add(songs.get(1).index); // 두 번째로 많이 재생된 노래
                }
            });
        
        // List<Integer>를 int[]로 변환
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // 노래 정보를 담는 내부 클래스
    static class Song {
        int index;  // 노래의 고유 번호
        int plays;  // 재생 횟수
        
        Song(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }
    }
}