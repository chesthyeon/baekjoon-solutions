import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        long[] cables = new long[K];
        long max = 0;
        
        for (int i = 0; i < K; i++) {
            cables[i] = Long.parseLong(br.readLine());
            max = Math.max(max, cables[i]);
        }
        
        long left = 1;
        long right = max;
        long result = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            
            for (long cable : cables) {
                count += cable / mid;
            }
            
            if (count >= N) {
                result = Math.max(result, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(result);
    }
}