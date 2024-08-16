import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        
        for (int number : numbers) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                queue.offer(current + number);
                queue.offer(current - number);
            }
        }
        
        int count = 0;
        while (!queue.isEmpty()) {
            if (queue.poll() == target) {
                count++;
            }
        }
        
        return count;
    }
}