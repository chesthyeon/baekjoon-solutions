import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        if (n == 0) {
            System.out.println(0);
            return;
        }
        
        int[] opinions = new int[n];
        for (int i = 0; i < n; i++) {
            opinions[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(opinions);
        
        int excludeCount = (int) Math.round(n * 0.15);
        double sum = 0;
        
        for (int i = excludeCount; i < n - excludeCount; i++) {
            sum += opinions[i];
        }
        
        int result = (int) Math.round(sum / (n - 2 * excludeCount));
        System.out.println(result);
    }
}