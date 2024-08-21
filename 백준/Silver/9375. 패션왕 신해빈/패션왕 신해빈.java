import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++){
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> clothes = new HashMap<>();
            StringTokenizer st;
            for (int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                String cloth = st.nextToken();
                String type  = st.nextToken();
                clothes.put(type, clothes.getOrDefault(type, 0) + 1);
            }
            long result = 1;
            for (int count : clothes.values()) {
                result *= (count + 1);
            }

            System.out.println(result - 1);
        }
    }
}