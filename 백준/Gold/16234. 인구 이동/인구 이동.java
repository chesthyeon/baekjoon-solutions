import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R;
    static int[][] population;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        population = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                population[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int days = 0;
        while (true) {
            visited = new boolean[N][N];
            boolean moved = false;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        List<int[]> union = bfs(i, j);
                        if (union.size() > 1) {
                            moved = true;
                            redistribute(union);
                        }
                    }
                }
            }
            
            if (!moved) break;
            days++;
        }
        
        System.out.println(days);
    }
    
    static List<int[]> bfs(int startX, int startY) {
        Queue<int[]> queue = new ArrayDeque<>();
        List<int[]> union = new ArrayList<>();
        
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        union.add(new int[]{startX, startY});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(population[x][y] - population[nx][ny]);
                    if (diff >= L && diff <= R) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        union.add(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return union;
    }
    
    static void redistribute(List<int[]> union) {
        int total = 0;
        for (int[] pos : union) {
            total += population[pos[0]][pos[1]];
        }
        
        int newPopulation = total / union.size();
        for (int[] pos : union) {
            population[pos[0]][pos[1]] = newPopulation;
        }
    }
}