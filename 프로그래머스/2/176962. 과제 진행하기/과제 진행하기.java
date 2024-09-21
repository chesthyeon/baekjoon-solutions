import java.util.*;

class Solution {
    // Task 클래스: 각 과제의 정보를 저장
    class Task {
        String name;    // 과제 이름
        int start;      // 시작 시간 (분 단위)
        int playtime;   // 실행 시간 (분 단위)

        Task(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }

    public String[] solution(String[][] plans) {
        // 시작 시간 순으로 정렬된 과제 큐
        PriorityQueue<Task> scheduledTasks = new PriorityQueue<>((a, b) -> a.start - b.start);
        // 일시 중지된 과제를 저장하는 스택
        Stack<Task> pausedTasks = new Stack<>();
        // 완료된 과제 이름을 저장하는 리스트
        List<String> completedTasks = new ArrayList<>();

        // plans 배열의 과제들을 Task 객체로 변환하여 우선순위 큐에 추가
        for (String[] plan : plans) {
            String[] startTime = plan[1].split(":");
            // 시작 시간을 분 단위로 변환 (예: "11:40" -> 700분)
            int start = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
            scheduledTasks.offer(new Task(plan[0], start, Integer.parseInt(plan[2])));
        }

        int currentTime = 0; // 현재 시간 (분 단위)

        // 모든 과제가 처리될 때까지 반복
        while (!scheduledTasks.isEmpty() || !pausedTasks.isEmpty()) {
            // 새로운 과제를 시작해야 하는 경우
            if (!scheduledTasks.isEmpty() && (pausedTasks.isEmpty() || scheduledTasks.peek().start <= currentTime)) {
                Task currentTask = scheduledTasks.poll();
                currentTime = Math.max(currentTime, currentTask.start);

                // 현재 과제 수행 중 다음 과제 시작 시간이 되는 경우
                if (!scheduledTasks.isEmpty() && scheduledTasks.peek().start < currentTime + currentTask.playtime) {
                    int remainingTime = scheduledTasks.peek().start - currentTime;
                    currentTask.playtime -= remainingTime;
                    pausedTasks.push(currentTask); // 현재 과제 일시 중지
                    currentTime += remainingTime;
                } else {
                    // 과제 완료
                    currentTime += currentTask.playtime;
                    completedTasks.add(currentTask.name);
                }
            } else if (!pausedTasks.isEmpty()) {
                // 일시 중지된 과제 재개
                Task resumedTask = pausedTasks.pop();
                // 재개된 과제 수행 중 다음 과제 시작 시간이 되는 경우
                if (!scheduledTasks.isEmpty() && scheduledTasks.peek().start < currentTime + resumedTask.playtime) {
                    int remainingTime = scheduledTasks.peek().start - currentTime;
                    resumedTask.playtime -= remainingTime;
                    pausedTasks.push(resumedTask); // 다시 일시 중지
                    currentTime += remainingTime;
                } else {
                    // 과제 완료
                    currentTime += resumedTask.playtime;
                    completedTasks.add(resumedTask.name);
                }
            }
        }

        // 완료된 과제 이름 배열 반환
        return completedTasks.toArray(new String[0]);
    }
}