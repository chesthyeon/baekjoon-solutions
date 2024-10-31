import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }
        Arrays.sort(strings, (a,b) -> {
            if (a.length() == b.length()) {
                int aNum = 0;
                int bNum = 0;
                for (int i = 0; i < a.length(); i++) {
                    if (Character.isDigit(a.charAt(i))) {
                        aNum += Character.getNumericValue(a.charAt(i));
                    }
                    if (Character.isDigit(b.charAt(i))) {
                        bNum += Character.getNumericValue(b.charAt(i));
                    }
                }
                if (aNum == bNum) {
                    return a.compareTo(b);
                }
                return aNum - bNum;
            }
            return a.length() - b.length();
        });
        Arrays.stream(strings).forEach(System.out::println);
    }
}