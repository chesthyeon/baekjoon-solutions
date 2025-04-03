
import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = IntStream.range(0, num_list.length).map(i -> num_list[num_list.length -1 - i]).toArray();
        return answer;
    }
}