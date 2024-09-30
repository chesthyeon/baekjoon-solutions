import java.util.*;

public class Main {
    static List<String> results = new ArrayList<>();
    static List<int[]> pairs = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        
        findPairs(expression);
        generateExpressions(expression, 0, new boolean[pairs.size()]);
        
        Collections.sort(results);
        results.stream().distinct().forEach(System.out::println);
    }
    
    static void findPairs(String expression) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                stack.push(i);
            } else if (expression.charAt(i) == ')') {
                pairs.add(new int[]{stack.pop(), i});
            }
        }
    }
    
    static void generateExpressions(String expression, int index, boolean[] used) {
        if (index == pairs.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < expression.length(); i++) {
                boolean skip = false;
                for (int j = 0; j < pairs.size(); j++) {
                    if (used[j] && (i == pairs.get(j)[0] || i == pairs.get(j)[1])) {
                        skip = true;
                        break;
                    }
                }
                if (!skip) sb.append(expression.charAt(i));
            }
            if (!sb.toString().equals(expression)) results.add(sb.toString());
            return;
        }
        
        used[index] = true;
        generateExpressions(expression, index + 1, used);
        used[index] = false;
        generateExpressions(expression, index + 1, used);
    }
}