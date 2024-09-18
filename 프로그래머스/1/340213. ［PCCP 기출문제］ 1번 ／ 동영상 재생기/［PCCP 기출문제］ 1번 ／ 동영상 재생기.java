import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLenSec = timeToSeconds(video_len);
        int currentPosSec = timeToSeconds(pos);
        int opStartSec = timeToSeconds(op_start);
        int opEndSec = timeToSeconds(op_end);

        if (currentPosSec >= opStartSec && currentPosSec <= opEndSec) {
            currentPosSec = opEndSec;
        }
        
        for (String command : commands) {
            if (command.equals("prev")) {
                currentPosSec = Math.max(0, currentPosSec - 10);
            } else if (command.equals("next")) {
                currentPosSec = Math.min(videoLenSec, currentPosSec + 10);
            }

            // 오프닝 건너뛰기 체크
            if (currentPosSec >= opStartSec && currentPosSec <= opEndSec) {
                currentPosSec = opEndSec;
            }
        }

        return secondsToTime(currentPosSec);
    }

    private int timeToSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private String secondsToTime(int seconds) {
        return LocalTime.ofSecondOfDay(seconds)
                .format(DateTimeFormatter.ofPattern("mm:ss"));
    }
}