import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        String pattern = sc.next();
        
        // '*'를 기준으로 앞뒤 분할
        int starIndex = pattern.indexOf('*');
        String prefix = pattern.substring(0, starIndex);
        String suffix = pattern.substring(starIndex + 1);
        
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            
            // 매칭 조건 체크
            boolean match = str.length() >= prefix.length() + suffix.length() &&
                           str.startsWith(prefix) && 
                           str.endsWith(suffix);
            
            System.out.println(match ? "DA" : "NE");
        }
    }
}