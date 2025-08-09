import java.io.*;
import java.util.*;

public class Main {
    static int r, c, k;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int time = 0;
        while (time <= 100) {
            if (r - 1 < arr.length && c - 1 < arr[0].length && arr[r - 1][c - 1] == k) {
                System.out.println(time);
                return;
            }
            
            if (arr.length >= arr[0].length) {
                arr = operationR(arr);
            } else {
                arr = operationC(arr);
            }
            
            time++;
        }
        
        System.out.println(-1);
    }
    
    static int[][] operationR(int[][] matrix) {
        List<List<Integer>> newMatrix = new ArrayList<>();
        int maxLength = 0;
        
        for (int i = 0; i < matrix.length; i++) {
            List<Integer> newRow = sortRow(matrix[i]);
            newMatrix.add(newRow);
            maxLength = Math.max(maxLength, newRow.size());
        }
        
        maxLength = Math.min(maxLength, 100);
        
        int[][] result = new int[matrix.length][maxLength];
        for (int i = 0; i < matrix.length; i++) {
            List<Integer> row = newMatrix.get(i);
            for (int j = 0; j < Math.min(row.size(), 100); j++) {
                result[i][j] = row.get(j);
            }
        }
        
        return result;
    }
    
    static int[][] operationC(int[][] matrix) {
        int[][] transposed = transpose(matrix);
        int[][] sortedTransposed = operationR(transposed);
        return transpose(sortedTransposed);
    }
    
    static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        
        return result;
    }
    
    static List<Integer> sortRow(int[] row) {
        Map<Integer, Integer> countMap = new HashMap<>();
        
        for (int num : row) {
            if (num != 0) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }
        
        List<int[]> pairs = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            pairs.add(new int[]{entry.getKey(), entry.getValue()});
        }
        
        pairs.sort((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });
        
        List<Integer> result = new ArrayList<>();
        for (int[] pair : pairs) {
            result.add(pair[0]);
            result.add(pair[1]);
        }
        
        return result;
    }
}