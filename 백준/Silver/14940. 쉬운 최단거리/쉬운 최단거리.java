import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] distance;
    static int N;
    static int M;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        distance = new int[N][M];

        int startX = 0, startY= 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                }
                if (map[i][j] != 0) {
                    distance[i][j] = -1;
                }
            }
        }

        bfs(startX, startY);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int n : distance[i]) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static public void bfs(int startX, int startY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY});
        distance[startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && distance[nx][ny] == -1) {
                    queue.offer(new int[]{nx, ny});
                    distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
                }
            }
        }
    }
}
