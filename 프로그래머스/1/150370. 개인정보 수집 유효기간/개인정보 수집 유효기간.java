import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> result = new ArrayList<>();
        
        // 오늘 날짜를 일 단위로 변환
        int todayDays = convertToDays(today);
        
        // 약관별 유효기간(일) 정리
        Map<String, Integer> termDays = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(" ");
            String type = parts[0];
            int months = Integer.parseInt(parts[1]);
            termDays.put(type, months * 28); // 한 달은 28일로 계산
        }
        
        // 각 개인정보 검사
        for (int i = 0; i < privacies.length; i++) {
            String[] parts = privacies[i].split(" ");
            String date = parts[0];
            String type = parts[1];
            
            int collectionDays = convertToDays(date);
            int expiryDays = collectionDays + termDays.get(type);
            
            if (expiryDays <= todayDays) {
                result.add(i + 1); // 1부터 시작하는 번호
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // 날짜를 일 단위로 변환하는 함수
    private int convertToDays(String date) {
        String[] parts = date.split("\\.");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);
        
        return (year * 12 * 28) + (month * 28) + day;
    }
}