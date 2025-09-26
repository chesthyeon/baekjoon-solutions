import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waiting = new ArrayDeque<>();
        Queue<Integer> bridge = new ArrayDeque<>();
        
        // 대기 트럭들을 큐에 넣기
        for (int truck : truck_weights) {
            waiting.offer(truck);
        }
        
        // 다리를 0으로 채우기
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int time = 0;
        int bridgeWeight = 0;
        
        while (!waiting.isEmpty()) {
            time++;
            
            // 다리에서 트럭 하나 빼기
            bridgeWeight -= bridge.poll();
            
            // 새 트럭이 들어갈 수 있는지 확인
            if (bridgeWeight + waiting.peek() <= weight) {
                int truck = waiting.poll();
                bridge.offer(truck);
                bridgeWeight += truck;
            } else {
                bridge.offer(0); // 못 들어가면 0 추가
            }
        }
        
        // 마지막 트럭이 다리를 완전히 건너는 시간 추가
        time += bridge_length;
        
        return time;
    }
}