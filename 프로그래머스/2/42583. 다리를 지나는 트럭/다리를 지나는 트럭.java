import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 다리 위 트럭을 관리하는 큐 [트럭무게, 진입시간]
        Queue<int[]> bridge = new LinkedList<>();
        
        int time = 0;        // 현재 시간
        int currentWeight = 0; // 다리 위 트럭 총 무게
        int truckIndex = 0;  // 대기 중인 트럭 인덱스
        
        // 모든 트럭이 다리를 건널 때까지 반복
        while (truckIndex < truck_weights.length || !bridge.isEmpty()) {
            time++; // 시간 증가
            
            // 다리를 빠져나갈 트럭이 있는지 확인
            if (!bridge.isEmpty() && time - bridge.peek()[1] >= bridge_length) {
                int[] exitTruck = bridge.poll();
                currentWeight -= exitTruck[0];
            }
            
            // 새 트럭이 다리에 진입할 수 있는지 확인
            if (truckIndex < truck_weights.length && 
                currentWeight + truck_weights[truckIndex] <= weight) {
                // 트럭을 다리에 추가 [트럭무게, 진입시간]
                bridge.offer(new int[]{truck_weights[truckIndex], time});
                currentWeight += truck_weights[truckIndex];
                truckIndex++;
            }
        }
        
        return time;
    }
}