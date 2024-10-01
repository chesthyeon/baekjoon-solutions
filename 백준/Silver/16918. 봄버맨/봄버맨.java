import java.io.*;
import java.util.*;

public class Main {
    static int R, C, N;
    static char[][] grid;
    static int[][] bombTime;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        bombTime = new int[R][C];

        // 초기 상태 입력
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'O') {
                    bombTime[i][j] = 3;  // 초기 폭탄은 3초 후에 폭발
                }
            }
        }

        // 시뮬레이션 시작
        for (int t = 2; t <= N; t++) {
            if (t % 2 == 0) {
                plantBombs(t);
            } else {
                explodeBombs(t);
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(grid[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void plantBombs(int time) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == '.') {
                    grid[i][j] = 'O';
                    bombTime[i][j] = time + 3;
                }
            }
        }
    }

    static void explodeBombs(int time) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (bombTime[i][j] == time) {
                    grid[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                            if (bombTime[nx][ny] != time) {
                                grid[nx][ny] = '.';
                                bombTime[nx][ny] = 0;
                            }
                        }
                    }
                }
            }
        }
    }
}