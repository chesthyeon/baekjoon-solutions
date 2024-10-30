import java.util.*;

class Solution {
    class Ticket {
        String from;
        String to;
        boolean used;
        
        public Ticket(String from, String to) {
            this.from = from;
            this.to = to;
            this.used = false;
        }
    }
    
    List<String> result;
    List<Ticket> tickets;
    
    public String[] solution(String[][] tickets) {
        this.tickets = new ArrayList<>();
        for (String[] ticket : tickets) {
            this.tickets.add(new Ticket(ticket[0], ticket[1]));
        }
        
        result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add("ICN"); // 시작은 항상 ICN
        
        dfs("ICN", path, tickets.length);
        
        return result.toArray(new String[0]);
    }
    
    private boolean dfs(String current, List<String> path, int totalTickets) {
        // 모든 티켓을 사용했다면
        if (path.size() == totalTickets + 1) {
            result = new ArrayList<>(path);
            return true;
        }
        
        // 현재 위치에서 출발하는 티켓들을 찾아서 알파벳 순으로 정렬
        List<Integer> candidates = new ArrayList<>();
        for (int i = 0; i < tickets.size(); i++) {
            if (!tickets.get(i).used && tickets.get(i).from.equals(current)) {
                candidates.add(i);
            }
        }
        
        // 알파벳 순으로 정렬
        candidates.sort((a, b) -> tickets.get(a).to.compareTo(tickets.get(b).to));
        
        // 가능한 모든 티켓에 대해 시도
        for (int index : candidates) {
            Ticket ticket = tickets.get(index);
            ticket.used = true;
            path.add(ticket.to);
            
            if (dfs(ticket.to, path, totalTickets)) {
                return true;
            }
            
            // 실패하면 백트래킹
            ticket.used = false;
            path.remove(path.size() - 1);
        }
        
        return false;
    }
}