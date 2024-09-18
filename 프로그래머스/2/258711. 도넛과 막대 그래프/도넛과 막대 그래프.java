class Solution {
    public int[] solution(int[][] edges) {
        // 가장 큰 노드 번호를 찾습니다.
        int maxNode = 0;
        for (int[] edge : edges){
            maxNode = Math.max(maxNode, Math.max(edge[0], edge[1]));
        }
        
        // 각 노드의 진입 차수와 진출 차수를 저장할 배열을 초기화합니다.
        int[] inDegree = new int[maxNode + 1];
        int[] outDegree = new int[maxNode + 1];

        // 모든 간선에 대해 진입 차수와 진출 차수를 계산합니다.
        for (int[] edge : edges){
            inDegree[edge[1]]++;
            outDegree[edge[0]]++;
        }
        
        int createdNode = 0; // 생성된 노드
        int stick = 0;       // 막대 모양 그래프 개수
        int eight = 0;       // 8자 모양 그래프 개수

        // 모든 노드를 순회하며 각 그래프 유형을 식별합니다.
        for (int i = 1; i <= maxNode; i++){
            if (outDegree[i] >= 2 && inDegree[i] == 0) {
                // 진출 차수가 2 이상이고 진입 차수가 0인 노드는 생성된 노드입니다.
                createdNode = i;
            } else if (outDegree[i] == 0 && inDegree[i] > 0) {
                // 진출 차수가 0이고 진입 차수가 있는 노드는 막대 모양 그래프의 끝 노드입니다.
                stick++;
            } else if (outDegree[i] >= 2 && inDegree[i] >= 2) {
                // 진출 차수와 진입 차수가 모두 2 이상인 노드는 8자 모양 그래프의 중앙 노드입니다.
                eight++;
            }
        }
        
        // 전체 그래프 개수는 생성된 노드의 진출 차수와 같습니다.
        int totalGraph = outDegree[createdNode];
        // 도넛 모양 그래프 개수는 전체 그래프 개수에서 막대와 8자 모양 그래프 개수를 뺀 것입니다.
        int donut = totalGraph - stick - eight;
        
        // 결과 배열을 생성하여 반환합니다.
        return new int[]{createdNode, donut, stick, eight};
    }
}