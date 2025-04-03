import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        Queue<Integer> deploy = new ArrayDeque<>();
        
        // 각 작업의 배포 가능일 계산
        for (int i = 0; i < n; i++) {
            deploy.offer((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        while (!deploy.isEmpty()) {
            int current = deploy.poll();
            int count = 1;
            
            // 현재 작업보다 먼저 완료되는 작업 모두 함께 배포
            while (!deploy.isEmpty() && deploy.peek() <= current) {
                deploy.poll();
                count++;
            }
            
            answer.add(count);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}