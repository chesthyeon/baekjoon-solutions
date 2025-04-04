import java.util.*;
import java.util.stream.*;

public class Solution {
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        // 부모 관계 맵
        Map<String, String> parent = IntStream.range(0, enroll.length)
                .boxed()
                .collect(Collectors.toMap(i -> enroll[i], i -> referral[i]));
        
        // 수익 맵
        Map<String, Integer> profit = new HashMap<>();
        
        // 판매 처리
        for (int i = 0; i < seller.length; i++) {
            String current = seller[i];
            int money = amount[i] * 100;
            
            while (!"-".equals(current) && money > 0) {
                int distribute = money / 10;
                profit.put(current, profit.getOrDefault(current, 0) + money - distribute);
                current = parent.get(current);
                money = distribute;
            }
        }
        
        // 결과 변환
        return Arrays.stream(enroll)
                .mapToInt(name -> profit.getOrDefault(name, 0))
                .toArray();
    }
}