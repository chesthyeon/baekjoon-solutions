
import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] challenger = new int[N + 2];
        for (int stage : stages) {
            challenger[stage]++;
        }

        HashMap<Integer, Double> fails = new HashMap<>();
        double total = stages.length;

        for (int stage = 1; stage <= N; stage++) {
            if (challenger[stage] == 0) {
                fails.put(stage, 0.);
            }
            else  {
                fails.put(stage, challenger[stage]/total);
                total -= challenger[stage];
            }
        }
        return fails.entrySet().stream().sorted(((o1, o2) ->
                o1.getValue().equals(o2.getValue()) ? Integer.compare(o1.getKey(), o2.getKey())
                : Double.compare(o2.getValue(), o1.getValue()))).mapToInt(Map.Entry::getKey).toArray();

    }
}