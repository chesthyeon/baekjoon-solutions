import java.util.*;

class Solution {
    public int solution(int N, int number) {
        // number가 N과 같으면 1개 사용
        if (N == number) return 1;
        
        // dp[i] = N을 i개 사용해서 만들 수 있는 모든 수들의 집합
        List<Set<Integer>> dp = new ArrayList<>();
        
        // 0번 사용하는 경우는 없으므로 인덱스 맞추기 위해 빈 집합 추가
        dp.add(new HashSet<>());
        
        // 1부터 8까지 계산
        for (int i = 1; i <= 8; i++) {
            Set<Integer> currentSet = new HashSet<>();
            
            // 1. N을 i번 연속으로 붙인 수 추가 (5 → 55 → 555 → ...)
            int repeatNumber = 0;
            for (int j = 0; j < i; j++) {
                repeatNumber = repeatNumber * 10 + N;
            }
            currentSet.add(repeatNumber);
            
            // 2. 이전 결과들을 조합해서 새로운 수 만들기
            for (int j = 1; j < i; j++) {
                Set<Integer> set1 = dp.get(j);           // N을 j번 사용한 수들
                Set<Integer> set2 = dp.get(i - j);       // N을 (i-j)번 사용한 수들
                
                // 두 집합의 모든 조합에 대해 사칙연산 수행
                for (int num1 : set1) {
                    for (int num2 : set2) {
                        // 덧셈
                        currentSet.add(num1 + num2);
                        
                        // 뺄셈 (양방향)
                        currentSet.add(num1 - num2);
                        currentSet.add(num2 - num1);
                        
                        // 곱셈
                        currentSet.add(num1 * num2);
                        
                        // 나눗셈 (0으로 나누기 방지)
                        if (num2 != 0) {
                            currentSet.add(num1 / num2);
                        }
                        if (num1 != 0) {
                            currentSet.add(num2 / num1);
                        }
                    }
                }
            }
            
            // 현재 집합을 dp에 추가
            dp.add(currentSet);
            
            // target을 찾았으면 현재 사용 개수 반환
            if (currentSet.contains(number)) {
                return i;
            }
        }
        
        // 8번까지 사용해도 찾지 못하면 -1 반환
        return -1;
    }
}