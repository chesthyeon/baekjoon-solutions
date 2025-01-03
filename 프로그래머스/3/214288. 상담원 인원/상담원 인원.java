import java.util.*;
import java.util.stream.*;

class Solution {
    List<List<Integer>> orders = new ArrayList<>(); // 분배가능한 모든 경우의 수

    public int solution(int k, int n, int[][] reqs) {
        int answer = Integer.MAX_VALUE;
        int[] area = new int[k+1];
        Arrays.fill(area, 1);
        backtracking(n-k, 1, area);

        for(List<Integer> order : orders){
            answer = Math.min(answer,simulation(k,order,reqs));
        }
        return answer;
    }
    // 모든 경우의 수를 구하는 함수(남은 인원, 유형, 컨테이너)
    void backtracking(int remain, int idx, int[] area) {
        if (remain <= 0) {
            List<Integer> areaList = Arrays.stream(area).boxed().collect(Collectors.toList());
            orders.add(areaList);
            return;
        }

        for (int i = idx; i < area.length; i++) {
            area[i]++;
            backtracking(remain-1, i, area);
            area[i]--;
        }
    }

    // 각 경우의 수에 맞춰 시뮬레이션을 돌림(순서,요청들)
    int simulation(int k, List<Integer> order, int[][] reqs){

        // 오름차순으로 뽑히는 우선순위큐를 유형의 수만큼 만듦
        PriorityQueue<Integer>[] pq = new PriorityQueue[k+1];
        int result = 0; // 대기 시간의 합

        for(int i = 1; i <= k; i++) {
            // 각 경우의 수에 맞춰 각 우선순위큐에 담음
            pq[i] = new PriorityQueue<>(Collections.nCopies(order.get(i), 0));
        }

        for(int[] req : reqs){
            int arrive = req[0]; // 요청 시각
            int time = req[1]; // 상담 시각
            int idx = req[2]; // 상담 유형

            // 해당 유형의 우선순위 큐에서 하나 뽑는다.
            int picked = pq[idx].poll();

            // 멘토의 시간 > 요청 시각
            if(picked > arrive) {
                result += picked-arrive;
                pq[idx].add(picked+time);
            }

            // 멘토의 시간 <= 요청 시각
            else {
                pq[idx].add(Math.max(picked, arrive) + time);
            }
        }

        return result;
    }
}