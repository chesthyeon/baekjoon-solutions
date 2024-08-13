import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        int total = 0;
        for (int i = 0; i < N; i++){
            total += Character.getNumericValue(numbers.charAt(i));
        }
        System.out.println(total);
        br.close();
    }
}