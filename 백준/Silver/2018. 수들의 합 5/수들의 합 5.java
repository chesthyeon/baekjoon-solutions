import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int count = 1; // N 자체를 포함
        for (int i = 2; i * (i + 1) / 2 <= N; i++) {
            if ((N - (i * (i - 1) / 2)) % i == 0) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}