import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[] nameArray = new String[N + 1];
        Map<String, Integer> indexMap = new HashMap<>();
        
        for (int i = 1; i <= N; i++){
            String name = br.readLine();
            nameArray[i] = name;
            indexMap.put(name, i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++){
            String input = br.readLine();
            if (indexMap.containsKey(input)){
                sb.append(indexMap.get(input)).append("\n");
            }
            else {
                sb.append(nameArray[Integer.parseInt(input)]).append("\n");
            }
        }
        System.out.println(sb);
    }
}