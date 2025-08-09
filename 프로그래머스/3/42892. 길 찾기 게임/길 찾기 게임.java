import java.util.*;

class Solution {
    static class Node {
        int x, y, id;
        Node left, right;
        
        Node(int x, int y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }
    
    static List<Integer> preorderResult;
    static List<Integer> postorderResult;
    
    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();
        
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1));
        }
        
        nodes.sort((a, b) -> {
            if (a.y == b.y) {
                return Integer.compare(a.x, b.x);
            }
            return Integer.compare(b.y, a.y);
        });
        
        Node root = nodes.get(0);
        for (int i = 1; i < nodes.size(); i++) {
            insertNode(root, nodes.get(i));
        }
        
        preorderResult = new ArrayList<>();
        postorderResult = new ArrayList<>();
        
        preorder(root);
        postorder(root);
        
        int[][] result = new int[2][];
        result[0] = preorderResult.stream().mapToInt(Integer::intValue).toArray();
        result[1] = postorderResult.stream().mapToInt(Integer::intValue).toArray();
        
        return result;
    }
    
    void insertNode(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }
    
    void preorder(Node node) {
        if (node == null) return;
        
        preorderResult.add(node.id);
        preorder(node.left);
        preorder(node.right);
    }
    
    void postorder(Node node) {
        if (node == null) return;
        
        postorder(node.left);
        postorder(node.right);
        postorderResult.add(node.id);
    }
}