import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> numsSet = new HashSet<>();
        for (int num :
                nums) {
            numsSet.add(num);
        }
        if (nums.length / 2 > numsSet.size()){
            answer = numsSet.size();
        }
        else {
            answer = nums.length / 2;
        }
        return answer;
    }
}