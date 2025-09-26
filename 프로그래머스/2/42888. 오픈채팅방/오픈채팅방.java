import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        Arrays.stream(record).map(i -> i.split(" ")).filter(j -> j.length == 3)
            .forEach(j -> map.put(j[1], j[2])); // j[1]이 사용자ID, j[2]가 닉네임
        
        return Arrays.stream(record).map(i -> i.split(" "))
            .filter(j -> "Enter".equals(j[0]) || "Leave".equals(j[0]))
            .map(j -> map.get(j[1]) + ("Enter".equals(j[0]) ? "님이 들어왔습니다." : "님이 나갔습니다."))
            .toArray(String[]::new);
    }
}