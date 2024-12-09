import java.util.*;

class Solution {
    private int n;
    private int[][] dice;
    private List<Integer> aSum;
    private List<Integer> bSum;
    
    public int[] solution(int[][] dice) {
        this.dice = dice;
        this.n = dice.length;
        int maxWin = 0;
        int[] bestChoice = null;
        
        // 주사위 조합을 비트마스크로 표현
        for (int i = 0; i < (1 << n); i++) {
            if (Integer.bitCount(i) != n/2) continue;
            
            // A와 B의 주사위 선택
            int[] aDice = new int[n/2];
            int[] bDice = new int[n/2];
            int aIdx = 0, bIdx = 0;
            
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    aDice[aIdx++] = j;
                } else {
                    bDice[bIdx++] = j;
                }
            }
            
            // 각 선택에 대한 승리 횟수 계산
            int winCount = calculateWinCount(aDice, bDice);
            
            // 최대 승리 횟수 갱신
            if (winCount > maxWin) {
                maxWin = winCount;
                bestChoice = aDice;
            }
        }
        
        // 1-based index로 변환
        int[] answer = new int[n/2];
        for (int i = 0; i < n/2; i++) {
            answer[i] = bestChoice[i] + 1;
        }
        Arrays.sort(answer);
        return answer;
    }
    
    private int calculateWinCount(int[] aDice, int[] bDice) {
        aSum = new ArrayList<>();
        bSum = new ArrayList<>();
        
        // A와 B의 주사위 눈의 합 계산
        calculateSums(aDice, 0, 0, true);
        calculateSums(bDice, 0, 0, false);
        
        // 정렬하여 이진 탐색 준비
        Collections.sort(bSum);
        
        // A가 이기는 경우 계산
        int winCount = 0;
        for (int a : aSum) {
            winCount += countWins(a);
        }
        
        return winCount;
    }
    
    private void calculateSums(int[] selectedDice, int depth, int currentSum, boolean isA) {
        if (depth == selectedDice.length) {
            if (isA) aSum.add(currentSum);
            else bSum.add(currentSum);
            return;
        }
        
        for (int i = 0; i < 6; i++) {
            calculateSums(selectedDice, depth + 1, 
                        currentSum + dice[selectedDice[depth]][i], isA);
        }
    }
    
    private int countWins(int aValue) {
        // 이진 탐색으로 A가 이기는 경우의 수 계산
        return binarySearch(aValue);
    }
    
    private int binarySearch(int aValue) {
        int left = 0;
        int right = bSum.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (bSum.get(mid) >= aValue) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}