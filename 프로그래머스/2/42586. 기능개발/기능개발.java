import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> daysQueue = new ArrayDeque<>();
        
        // 1. 각 작업의 배포 날짜 계산해서 큐에 넣기
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            daysQueue.add(days);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        // 2. 첫째 날부터 배포 시작
        while (!daysQueue.isEmpty()) {
            int firstDay = daysQueue.poll(); // 첫 번째 작업의 배포일
            int count = 1;
            
            // 3. 이 날짜보다 짧거나 같은 배포일들 카운트
            while (!daysQueue.isEmpty() && daysQueue.peek() <= firstDay) {
                daysQueue.poll();
                count++;
            }
            
            answer.add(count);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}