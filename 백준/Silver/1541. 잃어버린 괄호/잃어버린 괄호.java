import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();
        String[] subtractions = expression.split("-");
        int result = 0;
        for (int i = 0; i < subtractions.length; i++) {
            int sum = sumParts(subtractions[i]);
            if (i == 0){
                result += sum;
            }
            else {
                result -= sum;
            }
        }
        System.out.println(result);
    }
    static int sumParts(String part){
        String[] additions = part.split("\\+");
        int sum = 0;
        for (String num :
                additions) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }
}