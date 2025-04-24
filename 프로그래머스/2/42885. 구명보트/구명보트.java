import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        int cnt = 0;
        while (left <= right) {
            int pLeft = people[left];
            int pRight = people[right];
            if (pLeft + pRight <= limit) {
                // 두 명이 함께 탈 수 있으면 left도 증가
                left += 1;
            }
            // 항상 무거운 사람(right)은 처리
            right -= 1;
            cnt += 1;
        }
        return cnt;
    }
}