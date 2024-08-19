import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        
        // ArrayList를 사용하여 수를 저장
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        
        // Collections.sort()를 사용하여 정렬
        Collections.sort(list);
        
        // 정렬된 결과 출력
        for (int value : list) {
            bw.write(value + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}