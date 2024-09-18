import java.util.*;

class Solution {
    static class Robot {
        int r, c, nextStop;
        Robot(int r, int c) {
            this.r = r;
            this.c = c;
            this.nextStop = 1;
        }
        
        void move(int targetR, int targetC) {
            if (r != targetR) {
                r += Integer.compare(targetR, r);
            } else if (c != targetC) {
                c += Integer.compare(targetC, c);
            }
        }
        
        boolean hasArrived(int targetR, int targetC) {
            return r == targetR && c == targetC;
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
        List<Robot> robots = initializeRobots(points, routes);
        int collisionCount = countInitialCollisions(routes);
        
        while (!allRobotsFinished(robots, routes[0].length)) {
            Map<String, Integer> positions = new HashMap<>();
            moveRobots(robots, points, routes, positions);
            collisionCount += countCollisions(positions);
        }
        
        return collisionCount;
    }
    
    private List<Robot> initializeRobots(int[][] points, int[][] routes) {
        List<Robot> robots = new ArrayList<>();
        for (int[] route : routes) {
            int startPoint = route[0] - 1;
            robots.add(new Robot(points[startPoint][0], points[startPoint][1]));
        }
        return robots;
    }
    
    private int countInitialCollisions(int[][] routes) {
        Map<Integer, Integer> startPositions = new HashMap<>();
        for (int[] route : routes) {
            startPositions.merge(route[0], 1, Integer::sum);
        }
        return (int) startPositions.values().stream().filter(count -> count > 1).count();
    }
    
    private boolean allRobotsFinished(List<Robot> robots, int routeLength) {
        return robots.stream().allMatch(robot -> robot.nextStop >= routeLength);
    }
    
    private void moveRobots(List<Robot> robots, int[][] points, int[][] routes, Map<String, Integer> positions) {
        for (int i = 0; i < robots.size(); i++) {
            Robot robot = robots.get(i);
            if (robot.nextStop < routes[i].length) {
                int[] targetPoint = points[routes[i][robot.nextStop] - 1];
                robot.move(targetPoint[0], targetPoint[1]);
                
                String posKey = robot.r + "," + robot.c;
                positions.merge(posKey, 1, Integer::sum);
                
                if (robot.hasArrived(targetPoint[0], targetPoint[1])) {
                    robot.nextStop++;
                }
            }
        }
    }
    
    private int countCollisions(Map<String, Integer> positions) {
        return (int) positions.values().stream().filter(count -> count > 1).count();
    }
}