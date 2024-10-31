import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 회의 시간 정보를 저장할 2차원 배열
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return a - b;
        });
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }
        int cnt = 0;
        int ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
            cnt += ans;
        }
        System.out.println(cnt);

    }
}