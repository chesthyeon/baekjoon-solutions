import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] lab;
    static List<int[]> virusPositions;
    static int emptyCount;
    static int minTime = Integer.MAX_VALUE;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        lab = new int[N][N];
        virusPositions = new ArrayList<>();
        emptyCount = 0;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    virusPositions.add(new int[]{i, j});
                } else if (lab[i][j] == 0) {
                    emptyCount++;
                }
            }
        }
        
        if (emptyCount == 0) {
            System.out.println(0);
            return;
        }
        
        combination(0, 0, new ArrayList<>());
        
        if (minTime == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minTime);
        }
    }
    
    static void combination(int idx, int count, List<int[]> selected) {
        if (count == M) {
            int time = bfs(selected);
            if (time != -1) {
                minTime = Math.min(minTime, time);
            }
            return;
        }
        
        if (idx == virusPositions.size()) {
            return;
        }
        
        selected.add(virusPositions.get(idx));
        combination(idx + 1, count + 1, selected);
        selected.remove(selected.size() - 1);
        
        combination(idx + 1, count, selected);
    }
    
    static int bfs(List<int[]> activeViruses) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] visited = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], -1);
        }
        
        for (int[] virus : activeViruses) {
            queue.offer(new int[]{virus[0], virus[1], 0});
            visited[virus[0]][virus[1]] = 0;
        }
        
        int maxTime = 0;
        int spreadCount = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int time = current[2];
            
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && 
                    lab[nx][ny] != 1 && visited[nx][ny] == -1) {
                    
                    visited[nx][ny] = time + 1;
                    queue.offer(new int[]{nx, ny, time + 1});
                    
                    if (lab[nx][ny] == 0) {
                        spreadCount++;
                        maxTime = Math.max(maxTime, time + 1);
                    }
                }
            }
        }
        
        return spreadCount == emptyCount ? maxTime : -1;
    }
}