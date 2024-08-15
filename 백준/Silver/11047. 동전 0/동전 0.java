import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[N - 1 - i] = Integer.parseInt(br.readLine());
        }
        int result = 0;
        for (int coin :
                coins) {
            result += K / coin;
            K %= coin;
        }
        System.out.println(result);
    }
}