import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        List<Integer> primes = generatePrimesUsingGoldbach(N);

        StringBuilder sb = new StringBuilder();
        for (int prime : primes) {
            if (prime >= M && prime <= N) {
                sb.append(prime).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static List<Integer> generatePrimesUsingGoldbach(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
                if ((long) i * i <= n) {
                    for (int j = i * i; j <= n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
        }

        return primes;
    }
}