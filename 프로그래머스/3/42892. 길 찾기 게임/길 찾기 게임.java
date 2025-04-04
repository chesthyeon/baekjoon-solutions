import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    
    private static class Node {
        int x, y, num;
        Node left, right;
        
        public Node(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    
    public int[][] solution(int[][] nodeinfo) {
        // 노드 배열 생성 및 정렬
        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }
        
        // y 내림차순, 같으면 x 오름차순 정렬
        Arrays.sort(nodes, (a, b) -> a.y == b.y ? a.x - b.x : b.y - a.y);
        
        // 트리 구성 (루트는 첫 번째 노드)
        Node root = nodes[0];
        for (int i = 1; i < nodes.length; i++) {
            insertNode(root, nodes[i]);
        }
        
        // 전위 순회와 후위 순회 결과 저장
        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();
        traversal(root, preOrder, postOrder);
        
        // 결과 반환
        return new int[][] {
            preOrder.stream().mapToInt(i -> i).toArray(),
            postOrder.stream().mapToInt(i -> i).toArray()
        };
    }
    
    // 노드 삽입 (x 좌표 비교해 왼쪽/오른쪽 결정)
    private static void insertNode(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }
    
    // 전위 순회와 후위 순회를 한번에 수행
    private static void traversal(Node node, ArrayList<Integer> pre, ArrayList<Integer> post) {
        if (node == null) return;
        
        pre.add(node.num);  // 전위 순회: 현재 노드 먼저 처리
        traversal(node.left, pre, post);
        traversal(node.right, pre, post);
        post.add(node.num); // 후위 순회: 왼쪽, 오른쪽 처리 후 현재 노드
    }
}