import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);
            if (absA == absB){
                return a - b;
            }
            return absA - absB;
        });
        for (int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            if (x != 0){
                priorityQueue.offer(x);
            }
            else {
                if (priorityQueue.isEmpty()){
                    stringBuilder.append("0\n");
                }
                else {
                    stringBuilder.append(priorityQueue.poll()).append("\n");
                }
            }
        }
        System.out.print(stringBuilder);
    }
}