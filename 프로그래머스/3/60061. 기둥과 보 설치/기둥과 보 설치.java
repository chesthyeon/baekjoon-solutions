import java.util.*;

class Solution {
    private Set<String> structures = new HashSet<>();
    
    public int[][] solution(int n, int[][] build_frame) {
        for (int[] frame : build_frame) {
            int x = frame[0], y = frame[1], type = frame[2], cmd = frame[3];
            
            if (cmd == 1) { // 설치
                if (canInstall(x, y, type)) {
                    structures.add(x + "," + y + "," + type);
                }
            } else { // 삭제
                structures.remove(x + "," + y + "," + type);
                if (!isAllValid()) {
                    structures.add(x + "," + y + "," + type); // 롤백
                }
            }
        }
        
        // 결과 정렬
        List<int[]> result = new ArrayList<>();
        for (String s : structures) {
            String[] parts = s.split(",");
            result.add(new int[]{Integer.parseInt(parts[0]), 
                               Integer.parseInt(parts[1]), 
                               Integer.parseInt(parts[2])});
        }
        
        result.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        
        return result.toArray(new int[result.size()][]);
    }
    
    // 설치 가능 여부 확인
    private boolean canInstall(int x, int y, int type) {
        if (type == 0) { // 기둥
            return y == 0 || // 바닥
                   exists(x, y - 1, 0) || // 아래 기둥
                   exists(x - 1, y, 1) || // 왼쪽 보
                   exists(x, y, 1); // 오른쪽 보
        } else { // 보
            return exists(x, y - 1, 0) || // 왼쪽 기둥
                   exists(x + 1, y - 1, 0) || // 오른쪽 기둥
                   (exists(x - 1, y, 1) && exists(x + 1, y, 1)); // 양쪽 보
        }
    }
    
    // 모든 구조물이 유효한지 확인
    private boolean isAllValid() {
        for (String s : structures) {
            String[] parts = s.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            int type = Integer.parseInt(parts[2]);
            
            if (!canInstall(x, y, type)) {
                return false;
            }
        }
        return true;
    }
    
    // 구조물 존재 여부 확인
    private boolean exists(int x, int y, int type) {
        return structures.contains(x + "," + y + "," + type);
    }
}