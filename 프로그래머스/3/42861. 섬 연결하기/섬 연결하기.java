import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        Arrays.sort(costs, (a, b) -> (a[2] - b[2]));

        int[] parents = new int[n];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = i;
        }

        int bridge = 0;
        for (int[] cost : costs) {
            int island1 = cost[0];
            int island2 = cost[1];
            int costNum = cost[2];

            if (find(island1, parents) == find(island2, parents)) {
                continue;
            }

            union(island1, island2, parents);
            bridge += 1;
            answer += costNum;

            if (bridge >= n - 1) {
                return answer;
            }
        }
        return answer;
    }

    int find(int island, int[] parents) {
        if (parents[island] == island) {
            return island;
        }
        return parents[island] = find(parents[island], parents);
    }
    void union(int island1, int island2, int[] parents){
        parents[find(island2, parents)] = find(island1, parents);
    }
}