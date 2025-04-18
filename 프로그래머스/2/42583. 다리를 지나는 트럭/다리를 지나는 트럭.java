import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int curWeight = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        // 다리 초기화
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int idx = 0; // 현재 처리할 트럭 인덱스
        
        // 모든 트럭이 다리를 건널 때까지
        while (idx < truck_weights.length) {
            // 다리의 맨 앞 요소 제거하고 무게 갱신
            curWeight -= bridge.poll();
            time++;
            
            // 현재 트럭이 다리에 올라갈 수 있는지 확인
            if (curWeight + truck_weights[idx] <= weight) {
                bridge.offer(truck_weights[idx]);
                curWeight += truck_weights[idx];
                idx++; // 다음 트럭으로 이동
            } else {
                bridge.offer(0); // 트럭이 올라갈 수 없으면 빈 공간 추가
            }
        }
        
        // 마지막 트럭이 다리를 완전히 건너는 시간 추가
        // 마지막 트럭이 들어간 직후 다리 길이만큼의 시간이 더 필요
        return time + bridge_length;
    }
}