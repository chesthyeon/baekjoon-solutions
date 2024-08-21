import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> sites = new HashMap<>();

        // 사이트 주소와 비밀번호 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            sites.put(site, password);
        }

        // 비밀번호 찾기 및 출력
        for (int i = 0; i < M; i++) {
            String site = br.readLine();
            bw.write(sites.get(site) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}