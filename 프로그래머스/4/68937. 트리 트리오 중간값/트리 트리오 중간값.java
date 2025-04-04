import java.util.*;

class Solution {
    public class ResultData {
        public List<Integer> list;
        public int depth;

        public ResultData(List<Integer> list, int depth) {
            this.list = list;
            this.depth = depth;
        }
    }
    public List<List<Integer>> map = new ArrayList<>();

    public ResultData bfs(int leaf, int n) {
        boolean[] chk = new boolean[n + 1];
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        q1.add(leaf);
        chk[leaf] = true;
        int depth = 0;
        List<Integer> list = new ArrayList<>();
        while(true) {
            //BFS 진행
            while (!q1.isEmpty()) {
                int cur = q1.poll();
                for (int next : map.get(cur)) {
                    if (chk[next]) continue;
                    chk[next] = true;
                    q2.add(next);
                }
            }

            if (q2.isEmpty())
                break;

            //결과 계산
            depth++;
            list = new ArrayList<>(q2);

            //q2 -> q1 옮겨줌
            while(!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        }
        return new ResultData(list, depth);
    }

    public int solution(int n, int[][] edges) {
        //초기화
        for (int i = 0; i <= n; i++)
            map.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            map.get(from).add(to);
            map.get(to).add(from);
        }

        //1. BFS를 통해서 1번에서 가장 먼 leaf 노드 구하기
        int cand = 0;
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] chk = new boolean[n+1];

        q.add(1);
        chk[1] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if (map.get(cur).size() == 1)
                cand = cur;
            for (int next : map.get(cur)) {
                if (chk[next]) continue;
                chk[next] = true;
                q.add(next);
            }
        }

        //2. 해당 leaf 노드에서 BFS 진행하여 최대 거리 및 최대 거리 개수를 구한다.
        ResultData result1 = bfs(cand, n);
        if (result1.list.size() > 1)
            return result1.depth;

        //3. 최대 거리 개수가 1개이면 해당 노드에서 다시 BFS 진행
        ResultData result2 = bfs(result1.list.get(0), n);
        if (result2.list.size() > 1)
            return result2.depth;
        else
            return result2.depth-1;
    }
}