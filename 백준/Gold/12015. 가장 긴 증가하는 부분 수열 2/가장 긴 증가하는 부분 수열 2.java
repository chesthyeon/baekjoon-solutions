import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // LIS를 저장할 리스트 (실제로는 각 길이별 최소 끝값을 저장)
        List<Integer> lis = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            
            // 현재 LIS의 마지막 원소보다 크면 추가
            if (lis.isEmpty() || lis.get(lis.size() - 1) < num) {
                lis.add(num);
            } else {
                // 이분 탐색으로 교체할 위치 찾기 (Lower Bound)
                int pos = lowerBound(lis, num);
                lis.set(pos, num);
            }
        }
        
        System.out.println(lis.size());
    }
    
    // Lower Bound: target 이상인 첫 번째 위치 찾기
    private static int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}