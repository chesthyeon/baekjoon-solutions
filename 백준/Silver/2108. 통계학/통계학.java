import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        int sum = 0;
        int[] count = new int[8001]; // -4000 ~ 4000

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            sum += numbers[i];
            count[numbers[i] + 4000]++;
        }

        Arrays.sort(numbers);

        // 1. 산술평균
        int mean = (int) Math.round((double) sum / N);

        // 2. 중앙값
        int median = numbers[N / 2];

        // 3. 최빈값
        int mode = 0;
        int maxCount = 0;
        boolean isSecond = false;

        for (int i = 0; i < 8001; i++) {
            if (count[i] > maxCount) {
                maxCount = count[i];
                mode = i - 4000;
                isSecond = false;
            } else if (count[i] == maxCount && !isSecond) {
                mode = i - 4000;
                isSecond = true;
            }
        }

        // 4. 범위
        int range = numbers[N - 1] - numbers[0];

        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}