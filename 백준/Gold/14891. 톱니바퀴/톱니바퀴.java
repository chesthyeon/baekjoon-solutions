import java.io.*;
import java.util.*;

public class Main {
    static int[][] gears = new int[4][8];
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 톱니바퀴 상태 입력
        for(int i = 0; i < 4; i++) {
            String line = br.readLine();
            for(int j = 0; j < 8; j++) {
                gears[i][j] = line.charAt(j) - '0';
            }
        }
        
        int K = Integer.parseInt(br.readLine());
        
        while(K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());
            
            visited = new boolean[4];
            rotate(gearNum, direction);
        }
        
        // 점수 계산
        int score = 0;
        for(int i = 0; i < 4; i++) {
            if(gears[i][0] == 1) {
                score += (1 << i);
            }
        }
        
        System.out.println(score);
    }
    
    static void rotate(int gearNum, int direction) {
        visited[gearNum] = true;
        
        // 왼쪽 톱니바퀴 확인
        if(gearNum > 0 && !visited[gearNum-1]) {
            if(gears[gearNum][6] != gears[gearNum-1][2]) {
                rotate(gearNum-1, -direction);
            }
        }
        
        // 오른쪽 톱니바퀴 확인
        if(gearNum < 3 && !visited[gearNum+1]) {
            if(gears[gearNum][2] != gears[gearNum+1][6]) {
                rotate(gearNum+1, -direction);
            }
        }
        
        // 현재 톱니바퀴 회전
        if(direction == 1) {
            rotateClockwise(gearNum);
        } else {
            rotateCounterClockwise(gearNum);
        }
    }
    
    static void rotateClockwise(int gearNum) {
        int temp = gears[gearNum][7];
        for(int i = 7; i > 0; i--) {
            gears[gearNum][i] = gears[gearNum][i-1];
        }
        gears[gearNum][0] = temp;
    }
    
    static void rotateCounterClockwise(int gearNum) {
        int temp = gears[gearNum][0];
        for(int i = 0; i < 7; i++) {
            gears[gearNum][i] = gears[gearNum][i+1];
        }
        gears[gearNum][7] = temp;
    }
}