import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int attackIndex = 0;  // 현재 처리 중인 공격의 인덱스
        int lastAttackTime = attacks[attacks.length - 1][0];  // 마지막 공격 시간
        int maxHealth = health;  // 최대 체력
        int consecutiveHealing = 0;  // 연속 힐링 시간

        // 마지막 공격 시간까지 시뮬레이션
        for (int curTime = 1; curTime <= lastAttackTime; curTime++) {
            // 현재 시간이 공격 시간과 일치하는 경우
            if (attackIndex < attacks.length && attacks[attackIndex][0] == curTime) {
                health -= attacks[attackIndex][1];  // 체력 감소
                consecutiveHealing = 0;  // 연속 힐링 초기화
                attackIndex++;  // 다음 공격으로 이동

                // 체력이 0 이하가 되면 캐릭터 사망
                if (health <= 0) {
                    return -1;
                }
            } 
            // 공격이 없는 시간
            else {
                health += bandage[1];  // 초당 회복량만큼 체력 회복
                consecutiveHealing++;  // 연속 힐링 시간 증가

                // 연속 힐링 시간이 밴드 시전 시간과 일치하면 추가 회복
                if (consecutiveHealing == bandage[0]) {
                    health += bandage[2];  // 추가 회복량만큼 체력 회복
                    consecutiveHealing = 0;  // 연속 힐링 초기화
                }

                // 최대 체력을 초과하지 않도록 조정
                health = Math.min(health, maxHealth);
            }
        }

        return health;  // 최종 체력 반환
    }
}

// 동작 설명:
// 1. 시간을 1부터 마지막 공격 시간까지 순차적으로 증가시키며 시뮬레이션을 진행합니다.
// 2. 각 시간마다 공격이 있는지 확인합니다:
//    - 공격이 있으면 체력을 감소시키고 연속 힐링을 초기화합니다.
//    - 체력이 0 이하가 되면 즉시 -1을 반환합니다.
// 3. 공격이 없는 시간에는:
//    - 초당 회복량만큼 체력을 회복시킵니다.
//    - 연속 힐링 시간을 증가시킵니다.
//    - 연속 힐링이 밴드 시전 시간과 일치하면 추가 회복을 하고 연속 힐링을 초기화합니다.
//    - 체력이 최대 체력을 초과하지 않도록 조정합니다.
// 4. 모든 공격이 끝난 후 남은 체력을 반환합니다.