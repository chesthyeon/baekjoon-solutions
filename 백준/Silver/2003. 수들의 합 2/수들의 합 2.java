import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        int left = 0;
        int sum = 0;
        int count = 0;
        
        for (int right = 0; right < N; right++) {
            // 오른쪽 확장
            sum += arr[right];
            
            // sum이 M보다 크면 왼쪽 축소
            while (sum > M && left <= right) {
                sum -= arr[left];
                left++;
            }
            
            // 목표 합 발견!
            if (sum == M) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}