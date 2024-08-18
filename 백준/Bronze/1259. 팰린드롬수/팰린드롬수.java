import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String num = br.readLine();
            if (num.equals("0")) break;

            boolean isPalindrome = true;
            int left = 0;
            int right = num.length() - 1;

            while (left < right) {
                if (num.charAt(left) != num.charAt(right)) {
                    isPalindrome = false;
                    break;
                }
                left++;
                right--;
            }

            sb.append(isPalindrome ? "yes" : "no").append("\n");
        }

        System.out.print(sb);
    }
}