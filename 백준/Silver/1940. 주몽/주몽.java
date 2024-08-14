import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] materials = new int[N];
        for (int i = 0; i < N; i++){
            materials[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(materials);

        int count = 0;
        int left = 0;
        int right = N - 1;

        while (left < right){
            int sum = materials[left] + materials[right];
            if (sum == M){
                count++;
                left++;
                right--;
            }
            else if (sum < M){
                left++;
            }
            else right--;
        }
        System.out.print(count);
    }
}