import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String ,String >  map = new HashMap<>();
        map.put("Enter", "님이 들어왔습니다.");
        map.put("Leave", "님이 나갔습니다.");

        HashMap<String ,String > map2 = new HashMap<>();
        for(String r : record){
            String[] temp = r.split(" ");
            if (temp.length == 3) {
                map2.put(temp[1], temp[2]);
            }
        }
        ArrayList<String> answer = new ArrayList<>();
        for (String r : record) {
            String[] temp = r.split(" ");
            if (map.containsKey(temp[0])) {
                answer.add(map2.get(temp[1]) + map.get(temp[0]));
            }
        }
        return answer.toArray(new String[0]);
    }
}
