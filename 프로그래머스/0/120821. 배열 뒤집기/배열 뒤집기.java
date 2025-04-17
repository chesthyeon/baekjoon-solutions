import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int start = 0;
        int end = num_list.length - 1;
        while(end > start){
            int temp = num_list[end];
            num_list[end] = num_list[start];
            num_list[start] = temp;
            start++;
            end--;
        }

        return num_list;
    }
}