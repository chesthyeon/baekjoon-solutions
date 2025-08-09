import java.util.*;

class Solution {
    public List<Integer> solution(int[] fees, String[] records) {
        List<Integer> answer = new ArrayList<>();
        
        // fees 배열에서 요금 정보 추출
        int basicTime = fees[0];    // 기본 시간(분)
        int basicFee = fees[1];     // 기본 요금(원)
        int unitTime = fees[2];     // 단위 시간(분)
        int unitFee = fees[3];      // 단위 요금(원)
        
        // 차량번호별 총 주차시간 저장 (자동 정렬을 위해 TreeMap 사용)
        TreeMap<String, Integer> totalTime = new TreeMap<>();
        
        // 현재 주차 중인 차량의 입차 시간 저장
        HashMap<String, Integer> parkingLot = new HashMap<>();
        
        // 각 출입 기록 처리
        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];     // HH:MM
            String carNumber = parts[1]; // 차량번호
            String inOut = parts[2];     // IN 또는 OUT
            
            int minutes = timeToMinutes(time); // HH:MM을 분으로 변환
            
            if ("IN".equals(inOut)) {
                // 입차: 입차 시간 저장
                parkingLot.put(carNumber, minutes);
                // 차량번호를 totalTime에 등록 (0으로 초기화)
                totalTime.putIfAbsent(carNumber, 0);
            } else { // "OUT"
                // 출차: 주차 시간 계산하여 누적
                int inTime = parkingLot.get(carNumber);
                int parkingDuration = minutes - inTime;
                totalTime.put(carNumber, totalTime.get(carNumber) + parkingDuration);
                // 출차 완료된 차량은 주차장에서 제거
                parkingLot.remove(carNumber);
            }
        }
        
        // 아직 출차하지 않은 차량들 처리 (23:59에 출차로 간주)
        int endTime = timeToMinutes("23:59");
        for (Map.Entry<String, Integer> entry : parkingLot.entrySet()) {
            String carNumber = entry.getKey();
            int inTime = entry.getValue();
            int parkingDuration = endTime - inTime;
            totalTime.put(carNumber, totalTime.get(carNumber) + parkingDuration);
        }
        
        // 차량번호 순으로 정렬되어 있는 totalTime을 순회하며 요금 계산
        for (Map.Entry<String, Integer> entry : totalTime.entrySet()) {
            int totalParkingTime = entry.getValue();
            int fee = calculateFee(totalParkingTime, basicTime, basicFee, unitTime, unitFee);
            answer.add(fee);
        }
        
        return answer;
    }
    
    // HH:MM 형식을 분으로 변환하는 함수
    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }
    
    // 주차 요금 계산 함수
    private int calculateFee(int totalTime, int basicTime, int basicFee, int unitTime, int unitFee) {
        if (totalTime <= basicTime) {
            // 기본 시간 이하인 경우
            return basicFee;
        } else {
            // 기본 시간 초과인 경우
            int extraTime = totalTime - basicTime;
            // 올림 계산: (extraTime + unitTime - 1) / unitTime
            int extraUnits = (extraTime + unitTime - 1) / unitTime;
            return basicFee + (extraUnits * unitFee);
        }
    }
}