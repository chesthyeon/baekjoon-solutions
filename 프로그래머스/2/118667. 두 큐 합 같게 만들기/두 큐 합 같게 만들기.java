import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum1 = 0, sum2 = 0;
        
        // 큐 초기화 및 합계 계산
        for (int i : queue1) {
            q1.add(i);
            sum1 += i;
        }
        
        for (int i : queue2) {
            q2.add(i);
            sum2 += i;
        }
        
        // 전체 합이 홀수면 절대 같게 만들 수 없음
        if ((sum1 + sum2) % 2 != 0) return -1;
        
        long target = (sum1 + sum2) / 2;
        int count = 0;
        int limit = queue1.length * 3; // 최대 이동 횟수 제한
        
        while (sum1 != target && count < limit) {
            if (sum1 > target) {
                // q1에서 꺼내서 q2로 이동
                int val = q1.poll();
                q2.add(val);
                sum1 -= val;
                sum2 += val;
            } else {
                // q2에서 꺼내서 q1으로 이동
                int val = q2.poll();
                q1.add(val);
                sum1 += val;
                sum2 -= val;
            }
            count++;
        }
        
        return (sum1 == target) ? count : -1;
    }
}