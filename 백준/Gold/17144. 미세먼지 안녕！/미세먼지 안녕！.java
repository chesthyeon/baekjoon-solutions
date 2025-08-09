import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] room;
    static int airCleanerTop, airCleanerBottom;
    
    // 4방향: 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        room = new int[R][C];
        
        // 방 정보 입력 및 공기청정기 위치 찾기
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1) {
                    if (airCleanerTop == 0) {
                        airCleanerTop = i;
                    } else {
                        airCleanerBottom = i;
                    }
                }
            }
        }
        
        // T초 동안 시뮬레이션
        for (int time = 0; time < T; time++) {
            spreadDust();        // 1. 미세먼지 확산
            operateAirCleaner(); // 2. 공기청정기 작동
        }
        
        // 결과 출력
        System.out.println(getTotalDust());
    }
    
    // 미세먼지 확산 함수
    static void spreadDust() {
        int[][] newRoom = new int[R][C];
        
        // 공기청정기 위치 복사
        newRoom[airCleanerTop][0] = -1;
        newRoom[airCleanerBottom][0] = -1;
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) {
                    int dust = room[i][j];
                    int spreadAmount = dust / 5;
                    int spreadCount = 0;
                    
                    // 4방향으로 확산
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        
                        // 유효한 범위이고 공기청정기가 아닌 경우
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C && room[nx][ny] != -1) {
                            newRoom[nx][ny] += spreadAmount;
                            spreadCount++;
                        }
                    }
                    
                    // 남은 미세먼지
                    newRoom[i][j] += dust - (spreadAmount * spreadCount);
                }
            }
        }
        
        room = newRoom;
    }
    
    // 공기청정기 작동 함수
    static void operateAirCleaner() {
        // 위쪽 공기청정기 (반시계방향)
        cleanTop();
        
        // 아래쪽 공기청정기 (시계방향)
        cleanBottom();
    }
    
    // 위쪽 공기청정기 - 반시계방향 순환
    static void cleanTop() {
        int top = airCleanerTop;
        
        // 아래로 (공기청정기 오른쪽 열)
        for (int i = top - 1; i > 0; i--) {
            room[i][0] = room[i - 1][0];
        }
        
        // 왼쪽으로 (맨 위 행)
        for (int j = 0; j < C - 1; j++) {
            room[0][j] = room[0][j + 1];
        }
        
        // 위로 (맨 오른쪽 열)
        for (int i = 0; i < top; i++) {
            room[i][C - 1] = room[i + 1][C - 1];
        }
        
        // 오른쪽으로 (공기청정기 행)
        for (int j = C - 1; j > 1; j--) {
            room[top][j] = room[top][j - 1];
        }
        
        // 공기청정기에서 나오는 공기는 깨끗함
        room[top][1] = 0;
    }
    
    // 아래쪽 공기청정기 - 시계방향 순환
    static void cleanBottom() {
        int bottom = airCleanerBottom;
        
        // 위로 (공기청정기 오른쪽 열)
        for (int i = bottom + 1; i < R - 1; i++) {
            room[i][0] = room[i + 1][0];
        }
        
        // 왼쪽으로 (맨 아래 행)
        for (int j = 0; j < C - 1; j++) {
            room[R - 1][j] = room[R - 1][j + 1];
        }
        
        // 아래로 (맨 오른쪽 열)
        for (int i = R - 1; i > bottom; i--) {
            room[i][C - 1] = room[i - 1][C - 1];
        }
        
        // 오른쪽으로 (공기청정기 행)
        for (int j = C - 1; j > 1; j--) {
            room[bottom][j] = room[bottom][j - 1];
        }
        
        // 공기청정기에서 나오는 공기는 깨끗함
        room[bottom][1] = 0;
    }
    
    // 총 미세먼지 양 계산
    static int getTotalDust() {
        int total = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) {
                    total += room[i][j];
                }
            }
        }
        return total;
    }
}