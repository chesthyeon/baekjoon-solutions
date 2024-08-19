import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int minCount = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int count = countRepaint(board, i, j);
                minCount = Math.min(minCount, count);
            }
        }

        System.out.println(minCount);
    }

    public static int countRepaint(char[][] board, int startRow, int startCol) {
        int count1 = 0; // 'W'로 시작하는 경우
        int count2 = 0; // 'B'로 시작하는 경우

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    if (board[startRow + i][startCol + j] != 'W') count1++;
                    if (board[startRow + i][startCol + j] != 'B') count2++;
                } else {
                    if (board[startRow + i][startCol + j] != 'B') count1++;
                    if (board[startRow + i][startCol + j] != 'W') count2++;
                }
            }
        }

        return Math.min(count1, count2);
    }
}