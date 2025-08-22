import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        long[] weights = new long[26];
        
        // 가중치 계산
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            long power = 1;
            
            for (int j = word.length() - 1; j >= 0; j--) {
                weights[word.charAt(j) - 'A'] += power;
                power *= 10;
            }
        }
        
        // 가중치 순으로 정렬
        Integer[] indices = new Integer[26];
        for (int i = 0; i < 26; i++) indices[i] = i;
        Arrays.sort(indices, (a, b) -> Long.compare(weights[b], weights[a]));
        
        // 단순하게 9, 8, 7, ..., 0 배정
        long result = 0;
        int digit = 9;
        
        for (int i = 0; i < 26; i++) {
            if (weights[indices[i]] == 0) break;
            result += weights[indices[i]] * digit--;
        }
        
        System.out.println(result);
    }
}