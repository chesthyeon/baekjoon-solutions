import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] scores = new int[3]; // 각 학생의 점수를 저장할 배열

        // 각 문제에 대해 정답 여부 체크
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < patterns.length; j++) {
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++; // 수정된 부분: socores[i] -> scores[j]
                }
            }
        }

        // 최대 점수 찾기
        int max = Arrays.stream(scores).max().getAsInt();

        // 최대 점수를 가진 학생들의 번호를 찾아 리스트에 추가
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == max) {
                list.add(i + 1); // 학생 번호는 1부터 시작하므로 +1
            }
        }

        // 리스트를 배열로 변환
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}