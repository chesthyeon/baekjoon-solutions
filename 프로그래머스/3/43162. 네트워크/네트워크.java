class Solution {
    public int solution(int n, int[][] computers) {
        // 부모 노드 배열 초기화
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // 초기에는 자기 자신을 부모로 설정
        }
        
        // 연결된 컴퓨터들을 Union 연산으로 병합
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        
        // 서로 다른 네트워크의 수 계산
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) { // 자기 자신이 루트 노드인 경우
                count++;
            }
        }
        
        return count;
    }
    
    // Find 연산: 노드의 루트 노드를 찾는 함수 (경로 압축 적용)
    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // 경로 압축
        }
        return parent[x];
    }
    
    // Union 연산: 두 집합을 합치는 함수
    private void union(int[] parent, int a, int b) {
        a = find(parent, a);
        b = find(parent, b);
        
        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }
}