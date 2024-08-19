import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        TreeMap<Integer, ArrayList<String>> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            map.putIfAbsent(age, new ArrayList<>());
            map.get(age).add(name);
        }

        for (Map.Entry<Integer, ArrayList<String>> entry : map.entrySet()) {
            int age = entry.getKey();
            ArrayList<String> names = entry.getValue();
            for (String name : names) {
                bw.write(age + " " + name + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}