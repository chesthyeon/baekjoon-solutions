import java.util.Scanner;

public class Main {
    static int N, count = 0;
    static int[] col;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N];
        
        backtrack(0);
        System.out.println(count);
    }
    
    static void backtrack(int row) {
        if (row == N) {
            count++;
            return;
        }
        
        for (int c = 0; c < N; c++) {
            if (isValid(row, c)) {
                col[row] = c;
                backtrack(row + 1);
            }
        }
    }
    
    static boolean isValid(int row, int c) {
        for (int i = 0; i < row; i++) {
            if (col[i] == c || Math.abs(col[i] - c) == row - i) {
                return false;
            }
        }
        return true;
    }
}