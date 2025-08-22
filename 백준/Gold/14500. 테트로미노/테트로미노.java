/// https://www.acmicpc.net/problem/14500
/// 테트로미노


import java.util.*;
import java.io.*;


public class Main {
    static int num_max = 0;
    static final List<List<Integer>> paper = new ArrayList<>();
    static int n;
    static int m;
    static final int[] dx = {-1, 1, 0 ,0};
    static final int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            paper.add(new ArrayList<>());
            for (int j = 0; j < m; j++) {
                paper.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(new Pair(i,j,1,paper.get(i).get(j)));
                visited[i][j] = false;
            }
        }
        System.out.println(num_max);
    }

    public static void dfs(Pair p){
        if (p.depth == 4) {
            num_max = Math.max(num_max, p.sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = p.x + dx[i];
            int ny = p.y + dy[i];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) {
                continue;
            }
            if (p.depth == 2){
                visited[nx][ny] = true;
                dfs(new Pair(p.x, p.y, p.depth + 1 ,p.sum + paper.get(nx).get(ny)));
                visited[nx][ny] = false;
            }
            visited[nx][ny] = true;
            dfs(new Pair(nx, ny, p.depth + 1, p.sum + paper.get(nx).get(ny)));
            visited[nx][ny] = false;
        }
    }

    static class Pair {
        final int x;
        final int y;
        final int depth;
        final int sum;
        public Pair(int x, int y, int depth, int sum) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.sum = sum;
        }
    }
}
