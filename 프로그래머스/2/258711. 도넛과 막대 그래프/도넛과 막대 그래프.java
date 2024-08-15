import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int maxNode = 0;
        for (int[] edge : edges) {
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }
        
        int[] inDegree = new int[maxNode + 1];
        int[] outDegree = new int[maxNode + 1];
        
        for (int[] edge : edges) {
            outDegree[edge[0]]++;
            inDegree[edge[1]]++;
        }
        
        int createdNode = 0;
        int donut = 0, stick = 0, eight = 0;
        
        for (int i = 1; i <= maxNode; i++) {
            if (outDegree[i] >= 2 && inDegree[i] == 0) {
                createdNode = i;
            } else if (inDegree[i] == 0 && outDegree[i] == 0) {
                // 독립된 노드, 무시
            } else if (inDegree[i] >= 1 && outDegree[i] == 0) {
                stick++;
            } else if (inDegree[i] >= 2 && outDegree[i] == 2) {
                eight++;
            }
        }
        
        int totalGraphs = outDegree[createdNode];
        donut = totalGraphs - stick - eight;
        
        return new int[]{createdNode, donut, stick, eight};
    }
}