import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0, sum2 = 0;
        
        // 큐 초기화 및 합 계산
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        if ((sum1 + sum2) % 2 != 0) return -1;
        
        long target = (sum1 + sum2) / 2;
        int operations = 0;
        int maxOperations = queue1.length * 3; // 최대 시도 횟수
        
        while (operations < maxOperations) {
            if (sum1 == target) return operations;
            
            if (sum1 > target) {
                // queue1에서 queue2로 이동
                int val = q1.poll();
                q2.offer(val);
                sum1 -= val;
                sum2 += val;
            } else {
                // queue2에서 queue1로 이동  
                int val = q2.poll();
                q1.offer(val);
                sum1 += val;
                sum2 -= val;
            }
            operations++;
        }
        
        return -1;
    }
}