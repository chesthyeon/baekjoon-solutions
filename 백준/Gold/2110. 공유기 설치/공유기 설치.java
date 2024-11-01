import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());    // 집의 개수
        int C = Integer.parseInt(st.nextToken());    // 공유기 개수
        
        int[] houses = new int[N];
        for(int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);    // 이진 탐색을 위한 정렬
        
        // 이진 탐색 범위 설정
        int left = 1;    // 최소 거리
        int right = houses[N-1] - houses[0];    // 최대 거리
        int answer = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;    // 가능한 거리
            
            // 첫 번째 집은 무조건 설치
            int count = 1;    // 설치한 공유기 개수
            int lastInstalled = houses[0];    // 마지막으로 설치한 위치
            
            // 현재 거리(mid)로 설치 가능한 공유기 개수 계산
            for(int i = 1; i < N; i++) {
                if(houses[i] - lastInstalled >= mid) {
                    count++;
                    lastInstalled = houses[i];
                }
            }
            
            if(count >= C) {    // 필요한 개수보다 많이 설치할 수 있으면
                answer = mid;    // 현재 거리 저장
                left = mid + 1;  // 더 큰 거리 시도
            } else {            // 필요한 개수보다 적게 설치되면
                right = mid - 1; // 더 작은 거리 시도
            }
        }
        
        System.out.println(answer);
    }
}