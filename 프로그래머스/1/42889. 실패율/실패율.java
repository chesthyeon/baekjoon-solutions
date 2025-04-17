import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] playerAtStage = new int[N + 2];
        for(int i : stages){
            playerAtStage[i]++;
        }
        
        Map<Integer, Double> failureRates = new HashMap();
        int remainingPlayers = stages.length;
        
        for(int stageNum = 1; stageNum <= N; stageNum++){
            if(remainingPlayers == 0){
                failureRates.put(stageNum, 0.0);
                continue;
            }
            double failureRate = (double) playerAtStage[stageNum] / remainingPlayers;
            failureRates.put(stageNum, failureRate);
            
            remainingPlayers -= playerAtStage[stageNum];
        }
        
        List<Integer> sortedStages = new ArrayList<>(failureRates.keySet());
        sortedStages.sort((a, b) -> {
            // 실패율이 같다면 스테이지 번호가 작은 것이 먼저 오도록 정렬
            if (failureRates.get(b).equals(failureRates.get(a))) {
                return a - b;
            }
            // 실패율 내림차순 정렬
            return Double.compare(failureRates.get(b), failureRates.get(a));
        });
        
        return sortedStages.stream().mapToInt(Integer::intValue).toArray();
    }
}