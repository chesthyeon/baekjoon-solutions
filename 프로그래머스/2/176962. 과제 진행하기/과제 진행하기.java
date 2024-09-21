import java.util.*;

class Solution {
    class Task {
        String name;
        int start;
        int playtime;
        
        Task(String name, int start, int playtime) {
            this.name = name;
            this.start = start;
            this.playtime = playtime;
        }
    }
    
    public String[] solution(String[][] plans) {
        PriorityQueue<Task> scheduledTasks = new PriorityQueue<>((a, b) -> a.start - b.start);
        Stack<Task> pausedTasks = new Stack<>();
        List<String> completedTasks = new ArrayList<>();
        
        // Convert plans to Task objects and add to priority queue
        for (String[] plan : plans) {
            String[] startTime = plan[1].split(":");
            int start = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);
            scheduledTasks.offer(new Task(plan[0], start, Integer.parseInt(plan[2])));
        }
        
        int currentTime = 0;
        
        while (!scheduledTasks.isEmpty() || !pausedTasks.isEmpty()) {
            if (!scheduledTasks.isEmpty() && (pausedTasks.isEmpty() || scheduledTasks.peek().start <= currentTime)) {
                Task currentTask = scheduledTasks.poll();
                currentTime = Math.max(currentTime, currentTask.start);
                
                if (!scheduledTasks.isEmpty() && scheduledTasks.peek().start < currentTime + currentTask.playtime) {
                    int remainingTime = scheduledTasks.peek().start - currentTime;
                    currentTask.playtime -= remainingTime;
                    pausedTasks.push(currentTask);
                    currentTime += remainingTime;
                } else {
                    currentTime += currentTask.playtime;
                    completedTasks.add(currentTask.name);
                }
            } else if (!pausedTasks.isEmpty()) {
                Task resumedTask = pausedTasks.pop();
                if (!scheduledTasks.isEmpty() && scheduledTasks.peek().start < currentTime + resumedTask.playtime) {
                    int remainingTime = scheduledTasks.peek().start - currentTime;
                    resumedTask.playtime -= remainingTime;
                    pausedTasks.push(resumedTask);
                    currentTime += remainingTime;
                } else {
                    currentTime += resumedTask.playtime;
                    completedTasks.add(resumedTask.name);
                }
            }
        }
        
        return completedTasks.toArray(new String[0]);
    }
}