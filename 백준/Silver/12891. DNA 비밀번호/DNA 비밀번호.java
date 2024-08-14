import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String dna = br.readLine();

        st = new StringTokenizer(br.readLine());
        int[] min_count = new int[4];
        for (int i = 0; i < 4; i++){
            min_count[i] = Integer.parseInt(st.nextToken());
        }

        int[] count = new int[4];
        int result = 0;

        for (int i = 0; i < P; i++){
            addChar(dna.charAt(i), count);
        }
        if (check(min_count, count)) result++;

        for (int i = P; i < S; i++){
            int j = i - P;
            removeChar(dna.charAt(j), count);
            addChar(dna.charAt(i), count);
            if (check(min_count, count)) result++;
        }
        System.out.print(result);

    }
    static void addChar(char c, int[] count){
        switch (c){
            case 'A': count[0]++; break;
            case 'C': count[1]++; break;
            case 'G': count[2]++; break;
            case 'T': count[3]++; break;
        }
    }
    static void removeChar(char c, int[] count){
        switch (c){
            case 'A': count[0]--; break;
            case 'C': count[1]--; break;
            case 'G': count[2]--; break;
            case 'T': count[3]--; break;
        }
    }
    static boolean check(int[]min_count, int[]count){
        for (int i = 0; i < 4; i++){
            if (min_count[i] > count[i]) return false;
        }
        return true;
    }
}