import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (char digitChar : numbers.toCharArray()) {
            arrayList.add(Character.getNumericValue(digitChar));
        }

        Collections.sort(arrayList, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int digit : arrayList) {
            sb.append(digit);
        }

        System.out.println(sb);
    }
}