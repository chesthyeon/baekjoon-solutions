import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> cards1Queue = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> cards2Queue = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalQueue = new ArrayDeque<>(Arrays.asList(goal));

        while (!goalQueue.isEmpty()) {
            if (!cards1Queue.isEmpty() && cards1Queue.peek().equals(goalQueue.peek())) {
                cards1Queue.poll();
            } else if (!cards2Queue.isEmpty() && cards2Queue.peek().equals(goalQueue.peek())) {
                cards2Queue.poll();
            } else {
                break;
            }
            goalQueue.poll();

        }
        return goalQueue.isEmpty() ? "Yes" : "No";

    }
}