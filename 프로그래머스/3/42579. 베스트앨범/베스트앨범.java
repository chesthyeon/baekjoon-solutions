import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> genresPlayCount = new HashMap<>();
        Map<String, List<int[]>> genresSongs = new HashMap<>();

        //데이터 처리
        for (int i = 0; i < genres.length; i++){
            String genreName = genres[i];
            int playCount = plays[i];
            genresPlayCount.put(genreName, genresPlayCount.getOrDefault(genreName, 0) + playCount);
            genresSongs.computeIfAbsent(genreName, k -> new ArrayList<>()).add(new int[]{i, playCount});
        }
        List<String> sortedGenres = new ArrayList<>(genresPlayCount.keySet());
        Collections.sort(sortedGenres, (a, b) -> genresPlayCount.get(b) - genresPlayCount.get(a));

        for (String genre : sortedGenres){
            List<int[]> genreSong = genresSongs.get(genre);
            genreSong.sort((a, b) -> b[1] - a[1]);

            answer.add(genreSong.get(0)[0]);
            if (genreSong.size() > 1){
                answer.add(genreSong.get(1)[0]);
            }
        }
        return answer;
    }
}