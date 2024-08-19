import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int count = 0;
        
        // 5로 나누어 떨어지는 개수를 세기
        count += N / 5;
        
        // 25로 나누어 떨어지는 개수를 세기 (5가 한 번 더 곱해지므로)
        count += N / 25;
        
        // 125로 나누어 떨어지는 개수를 세기 (5가 또 한 번 더 곱해지므로)
        count += N / 125;
        
        System.out.println(count);
        
        br.close();
    }
}