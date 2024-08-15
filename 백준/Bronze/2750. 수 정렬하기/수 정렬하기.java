import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedREader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int N = Integer.parseInt(bufferedREader.readLine());
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for (int i = 0; i < N; i++){
            integerArrayList.add(Integer.parseInt(bufferedREader.readLine()));
        }
        Collections.sort(integerArrayList);
        for (int num : integerArrayList){
            stringBuilder.append(num).append("\n");
        }
        System.out.print(stringBuilder);
    }
}