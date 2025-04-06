import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 1. 모든 학생이 체육복을 가지고 있다고 가정
        int[] students = new int[n + 1];
        Arrays.fill(students, 1);
        
        // 2. 도난당한 학생은 체육복 -1
        for (int l : lost) {
            students[l]--;
        }
        
        // 3. 여벌 체육복이 있는 학생은 체육복 +1
        for (int r : reserve) {
            students[r]++;
        }
        
        // 4. 체육복 빌려주기 (앞번호부터 확인)
        for (int i = 1; i <= n; i++) {
            if (students[i] == 0) {  // 체육복이 없는 학생
                if (i > 1 && students[i-1] > 1) {  // 앞 번호 학생이 여벌 있으면
                    students[i-1]--;
                    students[i]++;
                } else if (i < n && students[i+1] > 1) {  // 뒷 번호 학생이 여벌 있으면
                    students[i+1]--;
                    students[i]++;
                }
            }
        }
        
        // 5. 체육복을 가진 학생 수 계산
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (students[i] > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}