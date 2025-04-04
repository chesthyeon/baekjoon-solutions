import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 상하좌우 이동 방향
    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {-1, 1, 0, 0};
    
    // 위치 정보 저장 클래스
    private static class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] maps) {
        int height = maps.length;
        int width = maps[0].length();
        
        // 맵 정보
        char[][] maze = new char[height][width];
        Point start = null, lever = null, exit = null;
        
        // 맵 초기화 및 주요 위치 찾기
        for (int i = 0; i < height; i++) {
            maze[i] = maps[i].toCharArray();
            for (int j = 0; j < width; j++) {
                if (maze[i][j] == 'S') start = new Point(j, i);
                else if (maze[i][j] == 'L') lever = new Point(j, i);
                else if (maze[i][j] == 'E') exit = new Point(j, i);
            }
        }
        
        // 시작 -> 레버, 레버 -> 출구 각각의 최단 거리 계산
        int distToLever = findShortestPath(maze, start, lever, height, width);
        int distToExit = findShortestPath(maze, lever, exit, height, width);
        
        // 둘 중 하나라도 도달할 수 없으면 -1 반환
        if (distToLever == -1 || distToExit == -1) {
            return -1;
        }
        
        // 총 이동 거리 반환
        return distToLever + distToExit;
    }
    
    // BFS로 두 지점 사이의 최단 경로 찾기
    private int findShortestPath(char[][] maze, Point start, Point end, int height, int width) {
        Queue<Point> queue = new LinkedList<>();
        int[][] distance = new int[height][width];
        
        // 시작점 설정
        queue.offer(start);
        distance[start.y][start.x] = 1; // 시작 위치를 1로 표시
        
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            
            // 목적지에 도달한 경우
            if (current.x == end.x && current.y == end.y) {
                return distance[current.y][current.x] - 1; // 실제 이동 횟수는 1을 빼줌
            }
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                // 맵 범위 체크 및 방문하지 않은 곳인지 확인
                if (nx >= 0 && nx < width && ny >= 0 && ny < height 
                    && maze[ny][nx] != 'X' && distance[ny][nx] == 0) {
                    
                    queue.offer(new Point(nx, ny));
                    distance[ny][nx] = distance[current.y][current.x] + 1;
                }
            }
        }
        
        // 도달할 수 없는 경우
        return -1;
    }
}