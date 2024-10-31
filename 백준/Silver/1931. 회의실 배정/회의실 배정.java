import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 회의 시간 정보를 저장할 2차원 배열
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        // 회의 정보 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pq.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});;
        }
        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            cnt++;
            while (!pq.isEmpty() && cur[1] > pq.peek()[0]) {
                pq.poll();
            }
        }
        System.out.println(cnt);
    }
}