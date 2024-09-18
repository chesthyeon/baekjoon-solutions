class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        // 지갑과 지폐의 크기를 정렬 (작은 값, 큰 값 순서로)
        int[] sortedWallet = sortArray(wallet);
        int[] sortedBill = sortArray(bill);
        
        // 지폐가 지갑에 들어갈 때까지 접기를 반복
        while (sortedBill[0] > sortedWallet[0] || sortedBill[1] > sortedWallet[1]) {
            // 긴 쪽을 접음
            if (sortedBill[1] > sortedBill[0]) {
                sortedBill[1] = sortedBill[1] / 2;
            } else {
                sortedBill[0] = sortedBill[0] / 2;
            }
            
            // 접은 후 재정렬
            sortedBill = sortArray(sortedBill);
            
            answer++;
        }
        
        return answer;
    }
    
    // 배열을 오름차순으로 정렬하는 헬퍼 메소드
    private int[] sortArray(int[] arr) {
        return arr[0] < arr[1] ? new int[]{arr[0], arr[1]} : new int[]{arr[1], arr[0]};
    }
}