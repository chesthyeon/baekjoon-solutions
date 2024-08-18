import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int totalShirts = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sizes = new int[6];
        for (int i = 0; i < 6; i++) {
            sizes[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        // 각 사이즈별 필요한 상자 수 계산
        for (int size : sizes) {
            totalShirts += (size / T + (size % T > 0 ? 1 : 0));
        }
        sb.append(totalShirts).append("\n");

        // 최대 주문 가능 세트 수와 남는 티셔츠 수 계산
        int maxSets = N / P;
        int remainingShirts = N % P;

        sb.append(maxSets).append(" ").append(remainingShirts);

        System.out.println(sb);
    }
}