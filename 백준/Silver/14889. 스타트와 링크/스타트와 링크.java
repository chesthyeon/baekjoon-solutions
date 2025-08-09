import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] selected;
    static int minDiff = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        S = new int[N][N];
        selected = new boolean[N];
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        combination(0, 0);
        System.out.println(minDiff);
    }
    
    static void combination(int idx, int count) {
        if (count == N / 2) {
            calculateDifference();
            return;
        }
        
        for (int i = idx; i < N; i++) {
            selected[i] = true;
            combination(i + 1, count + 1);
            selected[i] = false;
        }
    }
    
    static void calculateDifference() {
        List<Integer> startTeam = new ArrayList<>();
        List<Integer> linkTeam = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            if (selected[i]) {
                startTeam.add(i);
            } else {
                linkTeam.add(i);
            }
        }
        
        int startScore = calculateTeamScore(startTeam);
        int linkScore = calculateTeamScore(linkTeam);
        
        int diff = Math.abs(startScore - linkScore);
        minDiff = Math.min(minDiff, diff);
    }
    
    static int calculateTeamScore(List<Integer> team) {
        int score = 0;
        
        for (int i = 0; i < team.size(); i++) {
            for (int j = i + 1; j < team.size(); j++) {
                int player1 = team.get(i);
                int player2 = team.get(j);
                score += S[player1][player2] + S[player2][player1];
            }
        }
        
        return score;
    }
}