import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 여벌 있는 학생과 도난당한 학생을 Set으로 관리
        Set<Integer> reserves = new HashSet<>();
        Set<Integer> losts = new HashSet<>();
        
        // 여벌 체육복 가진 학생들 추가
        for (int r : reserve) reserves.add(r);
        
        // 도난당한 학생들 추가 (여벌 있는 학생이 도난당한 경우 제외)
        for (int l : lost) {
            if (reserves.contains(l)) reserves.remove(l);
            else losts.add(l);
        }
        
        // 체육복 빌려주기
        for (int i = 1; i <= n; i++) {
            if (losts.contains(i)) {
                if (reserves.contains(i-1)) {
                    reserves.remove(i-1);
                    losts.remove(i);
                } else if (reserves.contains(i+1)) {
                    reserves.remove(i+1);
                    losts.remove(i);
                }
            }
        }
        
        // 전체 학생 수 - 체육복이 없는 학생 수
        return n - losts.size();
    }
}