import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static class Problem implements Comparable<Problem>{
        int number;
        int difficulty;

        Problem(int number, int difficulty) {
            this.number = number;
            this.difficulty = difficulty;
        }

        @Override
        public int compareTo(Problem o) {
            if (difficulty != o.difficulty) {
                return difficulty - o.difficulty;
            }
            return number - o.number;
        }
    }

    static TreeSet<Problem> problems = new TreeSet<>();
    static Map<Integer, Problem> problemMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());
            Problem p = new Problem(number, difficulty);
            problems.add(p);
            problemMap.put(number, p);
        }
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            switch (cmd) {
                case "add":
                    int num = Integer.parseInt(st.nextToken());
                    int difficulty = Integer.parseInt(st.nextToken());
                    Problem p = new Problem(num, difficulty);
                    problems.add(p);
                    problemMap.put(num, p);
                    break;
                case "recommend":
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        sb.append(problems.last().number).append("\n");
                    } else {
                        sb.append(problems.first().number).append("\n");
                    }
                    break;
                case "solved":
                    num = Integer.parseInt(st.nextToken());
                    problems.remove(problemMap.get(num));
                    problemMap.remove(num);
                    break;
            }
        }
        System.out.println(sb);
    }
}