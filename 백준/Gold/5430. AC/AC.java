import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            String commands = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();
            
            // 배열 파싱
            Deque<Integer> deque = new ArrayDeque<>();
            if (n > 0) {
                String[] nums = arrStr.substring(1, arrStr.length() - 1).split(",");
                for (String num : nums) {
                    deque.add(Integer.parseInt(num));
                }
            }
            
            // 명령어 처리
            boolean reversed = false;
            boolean error = false;
            
            for (char cmd : commands.toCharArray()) {
                if (cmd == 'R') {
                    reversed = !reversed;
                } else { // cmd == 'D'
                    if (deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    
                    if (reversed) {
                        deque.removeLast();   // 뒤집힌 상태에서는 뒤에서 제거
                    } else {
                        deque.removeFirst();  // 정상 상태에서는 앞에서 제거
                    }
                }
            }
            
            // 결과 출력
            if (error) {
                sb.append("error\n");
            } else {
                sb.append("[");
                if (!deque.isEmpty()) {
                    if (reversed) {
                        // 뒤집힌 상태면 뒤에서부터 출력
                        Iterator<Integer> iter = deque.descendingIterator();
                        sb.append(iter.next());
                        while (iter.hasNext()) {
                            sb.append(",").append(iter.next());
                        }
                    } else {
                        // 정상 상태면 앞에서부터 출력
                        Iterator<Integer> iter = deque.iterator();
                        sb.append(iter.next());
                        while (iter.hasNext()) {
                            sb.append(",").append(iter.next());
                        }
                    }
                }
                sb.append("]\n");
            }
        }
        
        System.out.println(sb);
    }
}