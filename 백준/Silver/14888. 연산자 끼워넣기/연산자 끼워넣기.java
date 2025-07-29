import java.util.Scanner;

public class Main {
    static int N, max = -1000000000, min = 1000000000;
    static int[] nums, ops = new int[4];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            ops[i] = sc.nextInt();
        }
        
        dfs(1, nums[0]);
        
        System.out.println(max);
        System.out.println(min);
    }
    
    static void dfs(int idx, int result) {
        if (idx == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        
        // + 연산
        if (ops[0] > 0) {
            ops[0]--;
            dfs(idx + 1, result + nums[idx]);
            ops[0]++;
        }
        
        // - 연산
        if (ops[1] > 0) {
            ops[1]--;
            dfs(idx + 1, result - nums[idx]);
            ops[1]++;
        }
        
        // × 연산
        if (ops[2] > 0) {
            ops[2]--;
            dfs(idx + 1, result * nums[idx]);
            ops[2]++;
        }
        
        // ÷ 연산 (음수 나눗셈 주의)
        if (ops[3] > 0) {
            ops[3]--;
            int div = (result < 0) ? -(-result / nums[idx]) : result / nums[idx];
            dfs(idx + 1, div);
            ops[3]++;
        }
    }
}