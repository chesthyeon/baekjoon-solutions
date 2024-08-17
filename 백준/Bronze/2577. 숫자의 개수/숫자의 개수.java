import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int result = A * B * C;
        String s = (String.valueOf(result));

        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++) {
            count[Character.getNumericValue(s.charAt(i))]++;
        }

        StringBuffer output = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            output.append(count[i]).append('\n');
        }

        System.out.print(output);
    }
}