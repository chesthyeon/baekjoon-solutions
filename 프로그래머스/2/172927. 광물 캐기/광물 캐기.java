import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        List<List<String>> mineralGroups = new ArrayList<>();
        int totalPicks = Arrays.stream(picks).sum();

        for (int i = 0; i < Math.min(minerals.length, totalPicks * 5); i += 5) {
            mineralGroups.add(Arrays.asList(Arrays.copyOfRange(minerals, i, Math.min(i + 5, minerals.length))));
        }
        List<int[]> fatigueList = new ArrayList<>();
        for (List<String> group : mineralGroups) {
            int diamond = 0, iron = 0, stone = 0;
            for (String mineral : group) {
                switch (mineral) {
                    case "diamond": diamond++; break;
                    case "iron": iron++;       break;
                    case "stone": stone++;     break;
                }
            }
            fatigueList.add(new int[]{
                    diamond + iron + stone,
                    diamond * 5 + iron + stone,
                    diamond * 25 + iron * 5 + stone
            });
        }
        fatigueList.sort((a, b) -> b[2] - a[2]);
        int totalFatigue = 0;
        for (int[] fatigue : fatigueList) {
            if (picks[0] > 0) {
                totalFatigue += fatigue[0];
                picks[0]--;
            } else if (picks[1] > 0) {
                totalFatigue += fatigue[1];
                picks[1]--;
            } else if (picks[2] > 0) {
                totalFatigue += fatigue[2];
                picks[2]--;
            } else {
                break;
            }
        }

        return totalFatigue;
    }
}