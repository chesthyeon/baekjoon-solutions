import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;  // 특수 케이스 처리 추가

        List<HashSet<Integer>> dp = new ArrayList<>();
        for (int i = 0; i <= 8; i++) {  // 0~8까지 총 9개 생성
            dp.add(new HashSet<>());
        }

        dp.get(1).add(N);  // N을 1번 사용

        for (int i = 2; i <= 8; i++) {
            dp.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));  // N을 i번 반복
            for (int j = 1; j < i; j++) {
                int k = i - j;
                for (int a : dp.get(j)) {
                    for (int b : dp.get(k)) {
                        dp.get(i).add(a + b);
                        dp.get(i).add(a - b);
                        dp.get(i).add(a * b);
                        if (b != 0) dp.get(i).add(a / b);
                    }
                }
            }
            if (dp.get(i).contains(number)) return i;
        }

        return -1;
    }
}