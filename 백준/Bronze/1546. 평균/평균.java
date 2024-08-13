import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        int max_number = 0;
        float ans = 0;


        for(int i = 0; i<n; i++){
            int data = Integer.parseInt(st.nextToken());
            arr.add(data);
            max_number = Math.max(data,max_number);
        }

        for(int i = 0; i < n; i++){
            ans += (float)arr.get(i) / max_number * 100;
        }
        System.out.println(ans/n);
    }
}
