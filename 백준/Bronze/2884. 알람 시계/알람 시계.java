import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 시간을 분으로 변환하고 45분을 뺍니다
        int totalMinutes = H * 60 + M - 45;
        
        // 음수가 되면 하루의 총 분(24 * 60)을 더합니다
        if (totalMinutes < 0) {
            totalMinutes += 24 * 60;
        }
        
        // 다시 시간과 분으로 변환합니다
        H = totalMinutes / 60;
        M = totalMinutes % 60;
        
        System.out.println(H + " " + M);
    }
}