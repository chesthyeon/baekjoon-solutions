import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] coordinates = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coordinates[i][0] = Integer.parseInt(st.nextToken());  // x 좌표
            coordinates[i][1] = Integer.parseInt(st.nextToken());  // y 좌표
        }

        Arrays.sort(coordinates, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];  // x 좌표가 같으면 y 좌표로 비교
            }
            return a[0] - b[0];  // x 좌표로 비교
        });

        for (int[] coord : coordinates) {
            bw.write(coord[0] + " " + coord[1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}