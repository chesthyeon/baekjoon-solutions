import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        for (int[] command : commands){
            List<Integer> sliceArray = new ArrayList<>();
            int start = command[0], end = command[1], select = command[2];
            for (int i = start -1; i < end ; i++){
                sliceArray.add(array[i]);
            }
            sliceArray.sort(Comparator.naturalOrder());
            answer.add(sliceArray.get(select - 1));
        }
        return answer;
    }
}