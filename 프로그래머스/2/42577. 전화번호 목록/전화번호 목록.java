import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // 1. 모든 전화번호를 HashSet에 저장 (빠른 검색을 위해)
        HashSet<String> phoneSet = new HashSet<>();
        
        for (String phone : phone_book) {
            phoneSet.add(phone);
        }
        
        // 2. 각 전화번호에 대해 모든 접두어를 확인
        for (String phone : phone_book) {
            // 현재 전화번호의 모든 접두어를 체크
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);
                
                // 접두어가 전화번호 목록에 있다면 false
                if (phoneSet.contains(prefix)) {
                    return false;
                }
            }
        }
        
        // 모든 검사를 통과하면 true
        return true;
    }
}