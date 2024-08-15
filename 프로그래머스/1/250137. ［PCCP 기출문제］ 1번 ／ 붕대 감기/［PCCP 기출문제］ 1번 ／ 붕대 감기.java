import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int time = 0;
        int consecutiveHealing = 0;
        int attackIndex = 0;
        
        int lastAttackTime = attacks[attacks.length - 1][0];
        
        for (int currentTime = 1; currentTime <= lastAttackTime; currentTime++) {
            // 공격 시간인 경우
            if (attackIndex < attacks.length && currentTime == attacks[attackIndex][0]) {
                health -= attacks[attackIndex][1];
                consecutiveHealing = 0;
                attackIndex++;
                
                // 체력이 0 이하가 되면 캐릭터 사망
                if (health <= 0) {
                    return -1;
                }
            } else {
                // 붕대 감기
                health += bandage[1];
                consecutiveHealing++;
                
                // 연속 성공 보너스
                if (consecutiveHealing == bandage[0]) {
                    health += bandage[2];
                    consecutiveHealing = 0;
                }
                
                // 최대 체력을 초과하지 않도록 조정
                health = Math.min(health, maxHealth);
            }
        }
        
        return health;
    }
}