import java.util.Scanner;

public class Main {
    static int N, S, count = 0;
    static int[] arr;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        
        dfs(0, 0);
        
        // S가 0이면 공집합(합=0)도 카운트되므로 1 빼기
        if (S == 0) count--;
        
        System.out.println(count);
    }
    
    static void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum == S) count++;
            return;
        }
        
        dfs(idx + 1, sum);              // 현재 원소 미포함
        dfs(idx + 1, sum + arr[idx]);   // 현재 원소 포함
    }
}