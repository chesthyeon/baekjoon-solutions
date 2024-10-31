import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] visited = new int[100001];  // 방문 배열을 시간 저장 용도로 사용

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            // N이 K보다 크거나 같으면 뒤로 가는 방법밖에 없음
            System.out.println(N - K);
            return;
        }

        System.out.println(bfs() - 1);
    }

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        visited[N] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == K) {
                return visited[cur];
            }
            int[] next = {cur - 1, cur + 1, cur * 2};
            for (int n : next) {
                if (n < 0 || n > 100000 || visited[n] != 0) continue;
                q.add(n);
                visited[n] = visited[cur] + 1;
            }
        }

        return -1;
    }
}