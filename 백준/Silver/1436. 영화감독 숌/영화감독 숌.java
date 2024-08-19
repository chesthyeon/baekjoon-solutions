import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int count = 0;
        int number = 666;
        
        while (true) {
            if (String.valueOf(number).contains("666")) {
                count++;
            }
            
            if (count == N) {
                System.out.println(number);
                break;
            }
            
            number++;
        }
        
        br.close();
    }
}