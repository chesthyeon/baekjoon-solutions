import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] office;
    static List<int[]> cctvs;
    static int minBlindSpot = Integer.MAX_VALUE;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static int[][][] directions = {
        {},
        {{0}, {1}, {2}, {3}},
        {{0, 2}, {1, 3}},
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
        {{0, 1, 2, 3}}
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        office = new int[N][M];
        cctvs = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctvs.add(new int[]{i, j, office[i][j]});
                }
            }
        }
        
        backtrack(0, copyArray(office));
        System.out.println(minBlindSpot);
    }
    
    static void backtrack(int cctvIndex, int[][] currentOffice) {
        if (cctvIndex == cctvs.size()) {
            int blindSpot = countBlindSpot(currentOffice);
            minBlindSpot = Math.min(minBlindSpot, blindSpot);
            return;
        }
        
        int[] cctv = cctvs.get(cctvIndex);
        int x = cctv[0];
        int y = cctv[1];
        int type = cctv[2];
        
        for (int rotation = 0; rotation < directions[type].length; rotation++) {
            int[][] newOffice = copyArray(currentOffice);
            
            for (int dir : directions[type][rotation]) {
                watch(newOffice, x, y, dir);
            }
            
            backtrack(cctvIndex + 1, newOffice);
        }
    }
    
    static void watch(int[][] arr, int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        
        while (nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] != 6) {
            if (arr[nx][ny] == 0) {
                arr[nx][ny] = -1;
            }
            nx += dx[dir];
            ny += dy[dir];
        }
    }
    
    static int countBlindSpot(int[][] arr) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
    
    static int[][] copyArray(int[][] arr) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            copy[i] = arr[i].clone();
        }
        return copy;
    }
}