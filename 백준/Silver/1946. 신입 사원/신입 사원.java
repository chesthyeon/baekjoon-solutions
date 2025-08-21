import java.io.*;
import java.util.*;

public class Main {
    static class Applicant {
        int document, interview;
        
        Applicant(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            
            Applicant[] applicants = new Applicant[N];
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int doc = Integer.parseInt(st.nextToken());
                int inter = Integer.parseInt(st.nextToken());
                applicants[i] = new Applicant(doc, inter);
            }
            
            // 서류 순위로 정렬
            Arrays.sort(applicants, (a, b) -> a.document - b.document);
            
            int count = 0;
            int bestInterview = Integer.MAX_VALUE; // 현재까지 최고 면접 순위
            
            for (int i = 0; i < N; i++) {
                // 면접 성적이 현재까지 최고보다 좋으면 선발
                if (applicants[i].interview < bestInterview) {
                    count++;
                    bestInterview = applicants[i].interview;
                }
            }
            
            System.out.println(count);
        }
    }
}