class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int alarmCount = 0;
        int startTime = h1 * 3600 + m1 * 60 + s1;
        int endTime = h2 * 3600 + m2 * 60 + s2;

        // 시작 시간이 정각인 경우 처리
        if (startTime == 0 || startTime == 43200) {  // 0시 또는 12시
            alarmCount++;
        }

        while (startTime < endTime) {
            double hourAngle = (startTime % 43200) / 120.0;
            double minuteAngle = (startTime % 3600) / 10.0;
            double secondAngle = (startTime % 60) * 6.0;

            double nextHourAngle = ((startTime + 1) % 43200) / 120.0;
            double nextMinuteAngle = ((startTime + 1) % 3600) / 10.0;
            double nextSecondAngle = ((startTime + 1) % 60) * 6.0;

            // 0도를 360도로 변환
            nextHourAngle = nextHourAngle == 0 ? 360 : nextHourAngle;
            nextMinuteAngle = nextMinuteAngle == 0 ? 360 : nextMinuteAngle;
            nextSecondAngle = nextSecondAngle == 0 ? 360 : nextSecondAngle;

            // 초침이 시침을 지나는 경우
            if (secondAngle < hourAngle && nextSecondAngle >= nextHourAngle) {
                alarmCount++;
            }
            // 초침이 분침을 지나는 경우
            if (secondAngle < minuteAngle && nextSecondAngle >= nextMinuteAngle) {
                alarmCount++;
            }
            // 세 침이 모두 겹치는 경우 중복 카운트 제거
            if (nextSecondAngle == nextHourAngle && nextHourAngle == nextMinuteAngle) {
                alarmCount--;
            }

            startTime++;
        }

        return alarmCount;
    }
}