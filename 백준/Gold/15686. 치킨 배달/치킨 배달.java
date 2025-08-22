/// https://www.acmicpc.net/problem/15686
/// 치킨 배달 


import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int n = Integer.parseInt(st.nextToken());
        final int m = Integer.parseInt(st.nextToken());
        
        final List<Pair> houses = new ArrayList<>();
        final List<Pair> chickens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            final int[] line = new int[n];
            for (int j = 0; j < n; j++) {
                line[j] = Integer.parseInt(st.nextToken());
                if (line[j] == 1) {
                    houses.add(new Pair(i, j));
                } else if (line[j] == 2) {
                    chickens.add(new Pair(i, j));
                }
            }
        }
        
        final int[] arr = new int[chickens.size()];
        for (int i = 0; i < m; i++) {
            arr[i] = 1;
        }
        Arrays.sort(arr);
        
        int min = Integer.MAX_VALUE;
        do {
            int sum = 0;
            for (Pair house : houses) {
                int min_dist = Integer.MAX_VALUE;
                for (int i = 0; i < chickens.size(); i++) {
                    if (arr[i] == 1) {
                        min_dist = Math.min(min_dist, Math.abs(house.x - chickens.get(i).x) + Math.abs(house.y - chickens.get(i).y));
                    }
                }
                sum += min_dist;
            }
            min = Math.min(min, sum);
        } while (next_permutation(arr));
        System.out.println(min);
    }
    
    public static boolean next_permutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }
        
        int j = arr.length - 1;
        while (arr[j] <= arr[i - 1]) {
            j--;
        }
        
        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;
        
        j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
        return true;
    }
}

class Pair {
    int x;
    int y;
    
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}