import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String s) {
        int ans = 0;
        int pre = 0;
        for (String cmd : s.split(" ")) {
            if (cmd.equals("Z"))
                ans -= pre;
            else {
                pre = Integer.parseInt(cmd);
                ans += pre;
            }
        }
        return ans;
    }
}