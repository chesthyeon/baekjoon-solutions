import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        // 미사일을 종료 지점(e) 기준으로 오름차순 정렬
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;  // 요격 시스템 수
        int lastInterception = -1;  // 마지막 요격 지점
        
        for (int[] missile : targets) {
            int start = missile[0];
            int end = missile[1];
            
            // 현재 미사일의 시작점이 마지막 요격 지점보다 크면
            // 새로운 요격 시스템이 필요
            if (start > lastInterception) {
                count++;  // 요격 시스템 수 증가
                lastInterception = end - 1;  // 새로운 요격 지점 설정
            }
        }
        
        return count;
    }
}