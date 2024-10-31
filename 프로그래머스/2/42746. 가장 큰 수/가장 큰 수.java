import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 커스텀 비교자를 가진 우선순위 큐 생성
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            String order1 = b + a; // 순서 주의: b + a로 해야 내림차순
            String order2 = a + b;
            return order1.compareTo(order2);
        });
        
        // 숫자들을 문자열로 변환하여 우선순위 큐에 추가
        for (int number : numbers) {
            pq.offer(String.valueOf(number));
        }
        
        // 모든 수가 0인 경우 처리
        if (pq.peek().equals("0")) {
            return "0";
        }
        
        // 우선순위 큐에서 순서대로 추출하여 결과 문자열 생성
        StringBuilder answer = new StringBuilder();
        while (!pq.isEmpty()) {
            answer.append(pq.poll());
        }
        
        return answer.toString();
    }
}