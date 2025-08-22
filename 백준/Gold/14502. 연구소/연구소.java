/// https://www.acmicpc.net/problem/14502
/// 연구소


import java.util.*;
import java.io.*;


public class Main {
    static List<List<Integer>> virus_map = new ArrayList<>();
    static int max = Integer.MIN_VALUE;
    static List<int[]> virus_location = new ArrayList<>();
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            virus_map.add(new ArrayList<>());
            for (int j = 0; j < m; j++){
                int temp = Integer.parseInt(st.nextToken());
                virus_map.get(i).add(temp);
                if (temp == 2) {
                    virus_location.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < n * m - 2; i++) {
            int x1 = i / m;
            int y1 = i % m;
            if (virus_map.get(x1).get(y1) != 0) continue;

            for (int j = i + 1; j < n * m - 1; j++) {
                int x2 = j / m;
                int y2 = j % m;
                if (virus_map.get(x2).get(y2) != 0) continue;

                for (int k = j + 1; k < n * m; k++) {
                    int x3 = k / m;
                    int y3 = k % m;
                    if (virus_map.get(x3).get(y3) != 0) continue;

                    virus_map.get(x1).set(y1, 1);
                    virus_map.get(x2).set(y2, 1);
                    virus_map.get(x3).set(y3, 1);
                    spread_virus();
                    virus_map.get(x3).set(y3, 0);
                }
                virus_map.get(x2).set(y2, 0);
            }
            virus_map.get(x1).set(y1, 0);
        }
        System.out.println(max);
    }
    public static void spread_virus() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        List<List<Integer>> spread_virus_map = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            spread_virus_map.add(new ArrayList<>(virus_map.get(i)));
        }
        Queue<int[]> queue = new ArrayDeque<>();

        for (int[] temp : virus_location) {
            queue.add(temp);
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            spread_virus_map.get(cur[0]).set(cur[1], 2);
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (spread_virus_map.get(nx).get(ny) != 0) continue;
                queue.add(new int[]{nx, ny});
            }
        }
        get_safe_area(spread_virus_map);
    }
    public static void get_safe_area(List<List<Integer>> spread_virus_map){
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (spread_virus_map.get(i).get(j) == 0) cnt++;
            }
        }
        max = max < cnt ? cnt : max;
    }
}
