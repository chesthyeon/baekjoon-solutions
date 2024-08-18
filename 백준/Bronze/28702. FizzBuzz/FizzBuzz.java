import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = new String[3];
        
        for (int i = 0; i < 3; i++) {
            inputs[i] = br.readLine();
        }
        
        int lastNumber = 0;
        int offset = 0;
        
        for (int i = 0; i < 3; i++) {
            if (inputs[i].matches("\\d+")) {
                lastNumber = Integer.parseInt(inputs[i]);
                offset = 3 - i;
                break;
            }
        }
        
        if (lastNumber == 0) {
            // 모든 입력이 Fizz, Buzz, 또는 FizzBuzz인 경우
            if (inputs[2].equals("Fizz")) {
                System.out.println("Buzz");
            } else if (inputs[2].equals("Buzz")) {
                System.out.println("1");
            } else { // FizzBuzz
                System.out.println("Fizz");
            }
        } else {
            int nextNumber = lastNumber + offset;
            System.out.println(fizzBuzz(nextNumber));
        }
    }
    
    public static String fizzBuzz(int num) {
        if (num % 15 == 0) return "FizzBuzz";
        if (num % 3 == 0) return "Fizz";
        if (num % 5 == 0) return "Buzz";
        return String.valueOf(num);
    }
}