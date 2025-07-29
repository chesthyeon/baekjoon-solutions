import java.util.*;

class Solution {
    // 노래 정보를 담을 클래스
    class Song {
        int index;    // 고유 번호
        int plays;    // 재생 횟수
        String genre; // 장르
        
        Song(int index, int plays, String genre) {
            this.index = index;
            this.plays = plays;
            this.genre = genre;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 노래 리스트를 저장할 HashMap
        HashMap<String, List<Song>> genreSongs = new HashMap<>();
        
        // 2. 장르별 총 재생횟수를 저장할 HashMap
        HashMap<String, Integer> genreTotalPlays = new HashMap<>();
        
        // 3. 각 노래를 장르별로 분류하고 총 재생횟수 계산
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            // 노래 객체 생성
            Song song = new Song(i, play, genre);
            
            // 장르별 노래 리스트에 추가
            genreSongs.computeIfAbsent(genre, k -> new ArrayList<>()).add(song);
            
            // 장르별 총 재생횟수 누적
            genreTotalPlays.put(genre, genreTotalPlays.getOrDefault(genre, 0) + play);
        }
        
        // 4. 장르를 총 재생횟수 순으로 정렬 (내림차순)
        List<String> sortedGenres = new ArrayList<>(genreTotalPlays.keySet());
        sortedGenres.sort((a, b) -> genreTotalPlays.get(b) - genreTotalPlays.get(a));
        
        // 5. 각 장르 내에서 노래를 정렬하고 베스트앨범 구성
        List<Integer> result = new ArrayList<>();
        
        for (String genre : sortedGenres) {
            List<Song> songs = genreSongs.get(genre);
            
            // 장르 내 노래들을 정렬
            // 1순위: 재생횟수 내림차순, 2순위: 고유번호 오름차순
            songs.sort((a, b) -> {
                if (a.plays != b.plays) {
                    return b.plays - a.plays; // 재생횟수 내림차순
                }
                return a.index - b.index; // 고유번호 오름차순
            });
            
            // 각 장르에서 최대 2곡 선택
            int count = Math.min(2, songs.size());
            for (int i = 0; i < count; i++) {
                result.add(songs.get(i).index);
            }
        }
        
        // 6. List를 int 배열로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}