import java.util.*;

class Solution {
    // 방향에 따른 이동을 정의 (북, 남, 서, 동)
    private static final Map<Character, int[]> DIRECTIONS = Map.of(
        'N', new int[]{-1, 0},
        'S', new int[]{1, 0},
        'W', new int[]{0, -1},
        'E', new int[]{0, 1}
    );

    public int[] solution(String[] park, String[] routes) {
        int[] position = findStartPosition(park);
        int H = park.length;
        int W = park[0].length();

        for (String route : routes) {
            char direction = route.charAt(0);
            int distance = Character.getNumericValue(route.charAt(2));

            int[] newPosition = move(park, position, direction, distance, H, W);
            if (newPosition != null) {
                position = newPosition;
            }
        }

        return position;
    }

    // 시작 위치 'S'를 찾는 메서드
    private int[] findStartPosition(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0}; // 시작 위치가 없을 경우 기본값 반환
    }

    // 주어진 방향과 거리로 이동을 시도하는 메서드
    private int[] move(String[] park, int[] position, char direction, int distance, int H, int W) {
        int[] dir = DIRECTIONS.get(direction);
        int newX = position[0];
        int newY = position[1];

        for (int i = 0; i < distance; i++) {
            newX += dir[0];
            newY += dir[1];

            // 공원을 벗어나거나 장애물을 만나면 null 반환
            if (newX < 0 || newX >= H || newY < 0 || newY >= W || park[newX].charAt(newY) == 'X') {
                return null;
            }
        }

        return new int[]{newX, newY};
    }
}