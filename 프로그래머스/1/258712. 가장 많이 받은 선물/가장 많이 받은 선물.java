import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int n = friends.length;
        Map<String, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(friends[i], i);
        }

        int[][] giftMatrix = new int[n][n];
        int[] giftScore = new int[n];

        for (String gift : gifts) {
            String[] giftArray = gift.split(" ");
            int giver = indexMap.get(giftArray[0]);
            int receiver = indexMap.get(giftArray[1]);
            giftMatrix[giver][receiver]++;
            giftScore[giver]++;
            giftScore[receiver]--;
        }

        int[] nextMonthGifts = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (giftMatrix[i][j] > giftMatrix[j][i]) {
                    nextMonthGifts[i]++;
                } else if (giftMatrix[i][j] < giftMatrix[j][i]) {
                    nextMonthGifts[j]++;
                } else {
                    if (giftScore[i] > giftScore[j]) {
                        nextMonthGifts[i]++;
                    } else if (giftScore[i] < giftScore[j]) {
                        nextMonthGifts[j]++;
                    }
                }
            }
        }

        int answer = 0;
        for (int gift : nextMonthGifts) {
            answer = Math.max(answer, gift);
        }

        return answer;
    }
}