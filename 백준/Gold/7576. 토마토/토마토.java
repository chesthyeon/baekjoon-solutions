import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};  // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로

        int[][] box = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();
        int unripeCount = 0; // 익지 않은 토마토 개수

        // 입력 받기 및 초기 익은 토마토 찾기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());

                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j, 0}); // 행, 열, 일수
                } else if (box[i][j] == 0) {
                    unripeCount++;
                }
            }
        }

        // 처음부터 모든 토마토가 익어있는 경우
        if (unripeCount == 0) {
            System.out.println(0);
            return;
        }

        int days = 0;

        // BFS 탐색
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int day = current[2];

            days = day; // 마지막 날짜 업데이트

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위 체크 및 익지 않은 토마토인지 확인
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                    box[nx][ny] = 1; // 토마토 익히기
                    unripeCount--;   // 익지 않은 토마토 개수 감소
                    queue.offer(new int[]{nx, ny, day + 1});
                }
            }
        }

        // 모든 토마토가 익었는지 확인
        if (unripeCount == 0) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }
}