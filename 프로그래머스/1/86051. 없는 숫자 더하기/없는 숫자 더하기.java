import java.util.*;
class Solution {
    public int solution(int[] numbers) {
        int sum = Arrays.stream(numbers).reduce((a, b) -> a + b).getAsInt();
        return 45 - sum;
    }
}