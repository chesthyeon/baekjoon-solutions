import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        // 선수 이름과 현재 위치를 저장하는 HashMap
        Map<String, Integer> playerPositions = new HashMap<>();
        // 위치에 해당하는 선수 이름을 저장하는 배열
        String[] currentRanking = new String[players.length];
        
        // 초기 순위 설정
        for (int i = 0; i < players.length; i++) {
            playerPositions.put(players[i], i);
            currentRanking[i] = players[i];
        }
        
        // 경주 진행
        for (String calledPlayer : callings) {
            int currentPosition = playerPositions.get(calledPlayer);
            int newPosition = currentPosition - 1;
            
            // 앞 선수와 위치 교환
            String frontPlayer = currentRanking[newPosition];
            currentRanking[newPosition] = calledPlayer;
            currentRanking[currentPosition] = frontPlayer;
            
            // HashMap 업데이트
            playerPositions.put(calledPlayer, newPosition);
            playerPositions.put(frontPlayer, currentPosition);
        }
        
        return currentRanking;
    }
}