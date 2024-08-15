import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] colors;
    static final int RED = 1;
    static final int BLUE = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (K-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            colors = new int[V + 1];

            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            boolean isBipartite = true;
            for(int i = 1; i <= V; i++){
                if (colors[i] == 0){
                    if (!dfs(i, RED)){
                        isBipartite = false;
                        break;
                    }
                }
            }

            sb.append(isBipartite ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
    static boolean dfs(int node, int color){
        colors[node] = color;

        for (int neighbor : graph[node]){
            if (colors[neighbor] == color) return false;
            if (colors[neighbor] == 0 && !dfs(neighbor, -color)) return false;
        }
        return true;
    }
}