import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][][] visited;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static class State {
        int x, y, dist, broken;
        
        State(int x, int y, int dist, int broken) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.broken = broken;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        visited = new int[N][M][2];
        
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        
        System.out.println(bfs());
    }
    
    static int bfs() {
        Queue<State> queue = new ArrayDeque<>();
        queue.offer(new State(0, 0, 1, 0));
        visited[0][0][0] = 1;
        
        while (!queue.isEmpty()) {
            State current = queue.poll();
            int x = current.x;
            int y = current.y;
            int dist = current.dist;
            int broken = current.broken;
            
            if (x == N - 1 && y == M - 1) {
                return dist;
            }
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 0) {
                        if (visited[nx][ny][broken] == 0) {
                            visited[nx][ny][broken] = dist + 1;
                            queue.offer(new State(nx, ny, dist + 1, broken));
                        }
                    } else {
                        if (broken == 0 && visited[nx][ny][1] == 0) {
                            visited[nx][ny][1] = dist + 1;
                            queue.offer(new State(nx, ny, dist + 1, 1));
                        }
                    }
                }
            }
        }
        
        return -1;
    }
}