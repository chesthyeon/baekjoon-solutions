import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        // 1~8개의 N으로 만들 수 있는 수들을 저장할 집합 리스트
        List<Set<Integer>> sets = IntStream.rangeClosed(0, 8)
                .mapToObj(i -> new HashSet<Integer>())
                .collect(Collectors.toList());

        // N을 한 번 사용하는 경우
        sets.get(1).add(N);

        // 2~8개의 N 사용
        for (int i = 2; i <= 8; i++) {
            // N을 i번 연속해서 사용하는 경우 (예: 55, 555)
            sets.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));

            // 기존 집합들의 조합으로 계산
            for (int j = 1; j < i; j++) {
                int k = i - j;

                // 두 집합의 모든 수에 사칙연산 적용
                for (int a : sets.get(j)) {
                    for (int b : sets.get(k)) {
                        if (a + b > 0 && a + b <= 32000) sets.get(i).add(a + b);
                        if (a - b > 0) sets.get(i).add(a - b);
                        if (a * b > 0 && a * b <= 32000) sets.get(i).add(a * b);
                        if (b != 0 && a / b > 0) sets.get(i).add(a / b);
                    }
                }
            }

            // 찾는 수가 있는지 확인
            if (sets.get(i).contains(number)) return i;
        }

        return -1;
    }
}