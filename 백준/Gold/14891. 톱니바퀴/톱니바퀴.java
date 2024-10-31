import java.io.*;
import java.util.*;

class Gear {
    int[] teeth; // 톱니바퀴의 상태
    int west;    // 서쪽 위치 (2번 인덱스)
    int north;   // 북쪽 위치 (0번 인덱스)
    int east;    // 동쪽 위치 (6번 인덱스)
    
    public Gear(String state) {
        teeth = new int[8];
        for(int i = 0; i < 8; i++) {
            teeth[i] = state.charAt(i) - '0';
        }
        west = 6;  // 초기 위치 설정
        north = 0;
        east = 2;
    }
    
    // 시계 방향 회전
    public void clockwise() {
        west = (west + 7) % 8;
        north = (north + 7) % 8;
        east = (east + 7) % 8;
    }
    
    // 반시계 방향 회전
    public void counterClockwise() {
        west = (west + 1) % 8;
        north = (north + 1) % 8;
        east = (east + 1) % 8;
    }
    
    // 현재 톱니바퀴의 동쪽 극 얻기
    public int getEastPole() {
        return teeth[east];
    }
    
    // 현재 톱니바퀴의 서쪽 극 얻기
    public int getWestPole() {
        return teeth[west];
    }
    
    // 현재 톱니바퀴의 12시방향 극 얻기
    public int getNorthPole() {
        return teeth[north];
    }
}

public class Main {
    static Gear[] gears;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 톱니바퀴 4개 초기화
        gears = new Gear[4];
        for(int i = 0; i < 4; i++) {
            gears[i] = new Gear(br.readLine());
        }
        
        int K = Integer.parseInt(br.readLine());
        
        // K번 회전
        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;  // 0-based index로 변환
            int direction = Integer.parseInt(st.nextToken());
            
            rotate(gearNum, direction);
        }
        
        // 점수 계산
        int score = 0;
        for(int i = 0; i < 4; i++) {
            if(gears[i].getNorthPole() == 1) {
                score += (1 << i);
            }
        }
        
        System.out.println(score);
    }
    
    static void rotate(int gearNum, int direction) {
        // 각 톱니바퀴의 회전 방향을 저장할 배열
        int[] rotateDirection = new int[4];
        rotateDirection[gearNum] = direction;
        
        // 왼쪽 톱니바퀴들 확인
        for(int i = gearNum - 1; i >= 0; i--) {
            if(gears[i].getEastPole() != gears[i + 1].getWestPole()) {
                rotateDirection[i] = -rotateDirection[i + 1];
            } else {
                break;
            }
        }
        
        // 오른쪽 톱니바퀴들 확인
        for(int i = gearNum + 1; i < 4; i++) {
            if(gears[i].getWestPole() != gears[i - 1].getEastPole()) {
                rotateDirection[i] = -rotateDirection[i - 1];
            } else {
                break;
            }
        }
        
        // 모든 톱니바퀴 회전
        for(int i = 0; i < 4; i++) {
            if(rotateDirection[i] == 1) {
                gears[i].clockwise();
            } else if(rotateDirection[i] == -1) {
                gears[i].counterClockwise();
            }
        }
    }
}