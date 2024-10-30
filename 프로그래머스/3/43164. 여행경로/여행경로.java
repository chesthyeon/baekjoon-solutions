import java.util.*;

class Solution {
    TreeMap<String, PriorityQueue<String>> graph;
    List<String> route;
    int totalTickets;
    
    public String[] solution(String[][] tickets) {
        // TreeMap으로 변경: 출발지도 자동 정렬됨
        graph = new TreeMap<>();
        totalTickets = tickets.length;
        
        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).add(ticket[1]);
        }
        
        route = new ArrayList<>();
        route.add("ICN");
        dfs("ICN");
        
        return route.toArray(new String[0]);
    }
    
    private boolean dfs(String current) {
        if (route.size() == totalTickets + 1) {
            return true;
        }
        
        // 현재 공항에서 출발하는 항공편이 없는 경우
        if (!graph.containsKey(current) || graph.get(current).isEmpty()) {
            return false;
        }
        
        // 현재 공항에서 갈 수 있는 공항들을 탐색
        PriorityQueue<String> destinations = graph.get(current);
        String[] temp = destinations.toArray(new String[0]);
        
        for (String next : temp) {
            destinations.remove(next);
            route.add(next);
            
            if (dfs(next)) {
                return true;
            }
            
            route.remove(route.size() - 1);
            destinations.add(next);
        }
        
        return false;
    }
}