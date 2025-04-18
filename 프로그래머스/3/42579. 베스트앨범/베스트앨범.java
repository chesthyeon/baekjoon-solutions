import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> totalMap = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            totalMap.put(genre, totalMap.getOrDefault(genre, 0) + play);
            if (!songMap.containsKey(genre)) {
                songMap.put(genre, new ArrayList<>());
            }
            songMap.get(genre).add(new Song(i, play));
        }

        List<String> sortedTotal = new ArrayList<>(totalMap.keySet());
        sortedTotal.sort((o1, o2) -> {
            return totalMap.get(o2) - totalMap.get(o1);
        });

        List<Integer> ans = new ArrayList<>();
        for (String s : sortedTotal) {
            List<Song> songs = songMap.get(s);
            songs.sort((o1, o2) -> {
                if(o2.plays == o1.plays) return o1.index - o2.index;
                return o2.plays - o1.plays;
            });
            int cnt = Math.min(2, songs.size());
            for (int i = 0; i < cnt; i++) {
                ans.add(songs.get(i).index);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    class Song {
        int index;
        int plays;

        Song(int index, int plays) {
            this.index = index;
            this.plays = plays;
        }
    }
}
