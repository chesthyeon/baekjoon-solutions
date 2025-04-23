import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        List<String> stringList = new ArrayList<>(Arrays.asList(strings));
        stringList.sort((a, b) -> {
            if (a.charAt(n) == b.charAt(n)) {
                return a.compareTo(b);
            }
            return Character.compare(a.charAt(n), b.charAt(n));
        });
        return stringList.toArray(new String[0]);

    }
}