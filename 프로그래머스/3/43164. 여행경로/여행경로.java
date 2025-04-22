import java.util.*;

class Solution {
    boolean[] used;
    String[] answer;
    boolean finished;

    public String[] solution(String[][] tickets) {
        // 알파벳 순서로 티켓 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        used = new boolean[tickets.length];
        answer = new String[tickets.length + 1];
        finished = false;

        // 항상 "ICN"에서 출발
        answer[0] = "ICN";
        dfs(0, "ICN", tickets);

        return answer;
    }

    private void dfs(int depth, String current, String[][] tickets) {
        if (depth == tickets.length) {
            finished = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                answer[depth + 1] = tickets[i][1];

                dfs(depth + 1, tickets[i][1], tickets);

                if (!finished) {
                    used[i] = false;
                } else {
                    break;
                }
            }
        }
    }
}