import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int answer = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);
        System.out.println(answer);
    }
    static void clean(int x, int y, int direction) {
        if(map[x][y] == 0) {
            map[x][y] = 2; // 청소한 곳은 2로 표시
            answer++;
        }
        int origin = direction;
        for(int i = 0; i < 4; i++) {
            direction = (direction + 3) % 4; // 왼쪽으로 회전 (반시계 90도)
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 청소할 수 있는 공간이라면
            if(nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 0) {
                clean(nx, ny, direction);
                return;
            }
        }

        int back = (origin + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];

        // 후진할 수 있다면 (벽이 아니라면)
        if(bx >= 0 && by >= 0 && bx < N && by < M && map[bx][by] != 1) {
            clean(bx, by, origin); // 방향 유지한 채 후진
        }
    }
}