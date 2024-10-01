import java.io.*;
import java.util.*;

public class Main {
    static boolean visited[];
    static List<List<Integer>> graph = new ArrayList();
    static int res = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 컴퓨터의 수
        int m = Integer.parseInt(br.readLine()); // 연결된 컴퓨터 쌍의 수
        visited = new boolean[n + 1];
        while (n-- >= 0) {
            graph.add(new ArrayList<>());
        }
        while (m-- > 0) {
            String[] input = br.readLine().split(" ");
            int num1 = Integer.parseInt(input[0]);
            int num2 = Integer.parseInt(input[1]);
            graph.get(num1).add(num2);
            graph.get(num2).add(num1);
        }
        dfs(1);
        System.out.println(res - 1);
    }
    public static void dfs(int x){
        visited[x] = true;
        for (int next : graph.get(x)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
        res++;
    }
}
