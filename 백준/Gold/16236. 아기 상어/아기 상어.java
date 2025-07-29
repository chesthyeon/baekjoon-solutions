/// https://www.acmicpc.net/problem/16236
/// 아기 상어


import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        Shark start = null;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    start = new Shark(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }
        /// 문제 해결
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int shark_size = 2;
        int eat = 0;
        int time = 0;
        while (true){
            /// bfs init
            Queue<Shark> queue = new ArrayDeque<>();
            queue.add(start);
            boolean[][] visited = new boolean[n][n];
            visited[start.x][start.y] = true;
            /// bfs
            int min_dist = Integer.MAX_VALUE;
            int min_x = n;
            int min_y = n;
            while (!queue.isEmpty()) {
                Shark cur = queue.poll();
                if (cur.dist > min_dist) {
                    break;
                }
                /// find fish
                if (map[cur.x][cur.y] != 0 && map[cur.x][cur.y] < shark_size) {
                    if (cur.dist < min_dist) {
                        min_dist = cur.dist;
                        min_x = cur.x;
                        min_y = cur.y;
                    }
                    /// 거리가 같다면
                    else if (cur.dist == min_dist) {
                        /// 가장 왼쪽에 있는 물고기를 먹는다.
                        if (cur.x < min_x) {
                            min_x = cur.x;
                            min_y = cur.y;
                        }
                        /// 가장 위쪽에 있는 물고기를 먹는다.
                        else if (cur.x == min_x) {
                            if (cur.y < min_y) {
                                min_y = cur.y;
                            }
                        }
                    }
                }
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (visited[nx][ny]) {
                        continue;
                    }
                    if (map[nx][ny] > shark_size) {
                        continue;
                    }
                    queue.add(new Shark(nx, ny, cur.dist + 1));
                    visited[nx][ny] = true;
                }
            }
            /// no fish
            if (min_dist == Integer.MAX_VALUE) {
                break;
            }
            /// eat fish
            time += min_dist;
            eat += 1;
            if (eat == shark_size) {
                shark_size += 1;
                eat = 0;
            }
            map[min_x][min_y] = 0;
            start = new Shark(min_x, min_y, 0);
        }
        System.out.println(time);
    }
    static class Shark{
        int x;
        int y;
        int dist;

        public Shark(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}

