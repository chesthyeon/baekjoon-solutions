import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        return Arrays.stream(arr).filter(i -> i % divisor == 0).toArray().length == 0 ? 
               new int[] {-1} : 
               Arrays.stream(arr).filter(i -> i % divisor == 0).sorted().toArray();
    }
}