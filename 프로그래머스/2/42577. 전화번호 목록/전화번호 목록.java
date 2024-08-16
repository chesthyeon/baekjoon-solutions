import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 전화번호를 해시셋에 저장
        Set<String> phoneSet = new HashSet<>(Arrays.asList(phone_book));
        
        // 각 전화번호에 대해 가능한 모든 접두어를 확인
        for (String phoneNumber : phone_book) {
            for (int i = 1; i < phoneNumber.length(); i++) {
                String prefix = phoneNumber.substring(0, i);
                if (phoneSet.contains(prefix)) {
                    return false;  // 접두어가 발견되면 false 반환
                }
            }
        }
        
        // 접두어가 발견되지 않으면 true 반환
        return true;
    }
}