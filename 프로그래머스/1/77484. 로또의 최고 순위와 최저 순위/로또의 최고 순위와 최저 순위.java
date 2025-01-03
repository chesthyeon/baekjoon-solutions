import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        int zeroCnt = 0;
        int mattchCnt = 0;
        Set<Integer> win_nums_map = Arrays.stream(win_nums).boxed().collect(Collectors.toCollection(HashSet::new));
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCnt++;
            } else if (win_nums_map.contains(lotto)) {
                mattchCnt++;
            }
        }
        int max = 7 - (mattchCnt + zeroCnt) > 6 ? 6 : 7 - (mattchCnt + zeroCnt);
        int min = 7 - mattchCnt > 6 ? 6 : 7 - mattchCnt;
        answer = new int[]{max, min};
        return answer;
    }
}