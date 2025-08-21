import java.io.*;
import java.util.*;

public class Main {
    static class Jewel {
        int weight, value;
        
        Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        // 보석 입력
        Jewel[] jewels = new Jewel[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(w, v);
        }
        
        // 가방 입력
        int[] bags = new int[k];
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        
        // 정렬
        Arrays.sort(jewels, (a, b) -> a.weight - b.weight);  // 무게 순
        Arrays.sort(bags);  // 용량 순
        
        // 우선순위 큐 (최대힙 - 가격 기준)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long answer = 0;
        int jewelIdx = 0;
        
        // 작은 가방부터 처리
        for (int bagCapacity : bags) {
            // 현재 가방에 들어갈 수 있는 보석들을 큐에 추가
            while (jewelIdx < n && jewels[jewelIdx].weight <= bagCapacity) {
                pq.offer(jewels[jewelIdx].value);
                jewelIdx++;
            }
            
            // 가능한 보석 중 가장 비싼 것 선택
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        
        System.out.println(answer);
    }
}