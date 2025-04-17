import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] up = new int[n + 2];
        int[] down = new int[n + 2];
        Stack<Integer> deleted = new Stack<>();

        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }

        k += 1;

        for (String command : cmd) {
            char type = command.charAt(0);
            switch(type) {
                case 'U' -> {
                    int upCount = Integer.parseInt(command.substring(2));
                    for (int i = 0; i < upCount; i++) {
                        k = up[k];
                    }
                }
                case 'D' -> {
                    int downCount = Integer.parseInt(command.substring(2));
                    for (int i = 0; i < downCount; i++) {
                        k = down[k];
                    }
                }
                case 'C' -> {
                    deleted.push(k - 1);
                    up[down[k]] = up[k];
                    down[up[k]] = down[k];
                    k = n < down[k] ? up[k] : down[k];
                }
                case 'Z' -> {
                    int restore = deleted.pop() + 1; // 1-indexed로 변환

                    // 링크드 리스트에 복구
                    down[up[restore]] = restore;
                    up[down[restore]] = restore;
                }
            }
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            answer.append('O');
        }

        while (!deleted.isEmpty()) {
            answer.setCharAt(deleted.pop(), 'X');
        }

        return answer.toString();
    }
}