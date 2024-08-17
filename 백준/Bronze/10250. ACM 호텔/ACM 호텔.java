import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());  // 테스트 케이스의 개수

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());  // 호텔의 층 수
            int W = Integer.parseInt(st.nextToken());  // 각 층의 방 수
            int N = Integer.parseInt(st.nextToken());  // N번째 손님

            int floor = N % H;  // 배정될 층
            int roomNumber = (N / H) + 1;  // 엘리베이터부터의 거리

            if (floor == 0) {  // N이 H의 배수일 경우
                floor = H;
                roomNumber--;
            }

            sb.append(floor * 100 + roomNumber).append("\n");
        }

        System.out.print(sb);
    }
}