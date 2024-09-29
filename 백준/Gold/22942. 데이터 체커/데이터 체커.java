import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            points.add(new Point(x - r, i, true));  // 원의 왼쪽 끝
            points.add(new Point(x + r, i, false)); // 원의 오른쪽 끝
        }
        
        Collections.sort(points);
        
        Stack<Integer> stack = new Stack<>();
        for (Point p : points) {
            if (p.isStart) {
                stack.push(p.index);
            } else {
                if (stack.peek() == p.index) {
                    stack.pop();
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }
        
        System.out.println("YES");
    }
    
    static class Point implements Comparable<Point> {
        int x, index;
        boolean isStart;
        
        Point(int x, int index, boolean isStart) {
            this.x = x;
            this.index = index;
            this.isStart = isStart;
        }
        
        @Override
        public int compareTo(Point o) {
            return this.x - o.x;
        }
    }
}