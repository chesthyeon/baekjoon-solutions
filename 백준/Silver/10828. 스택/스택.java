import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static Integer tempValue;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        while (n > 0){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            switch (stringTokenizer.nextToken()){
                case "push":
                    push(Integer.parseInt(stringTokenizer.nextToken()));
                    break;
                case "pop":
                    System.out.println(pop());
                    break;
                case "size":
                    System.out.println(size());
                    break;
                case "empty":
                    System.out.println(empty());
                    break;
                case "top":
                    System.out.println(top());
                    break;
            }
            n--;
        }
    }
    public static void push(Integer data){
        arrayList.add(data);
    }
    public static Integer pop(){
        if (arrayList.size() == 0) return -1;
        tempValue = arrayList.get(arrayList.size() - 1);
        arrayList.remove(arrayList.size() - 1);
        return tempValue;
    }
    public static Integer size(){
        return arrayList.size();
    }
    public static Integer empty(){
        if (arrayList.size() == 0) return 1;
        return 0;
    }
    public static Integer top(){
        if (arrayList.size() == 0) return -1;
        return arrayList.get(arrayList.size() - 1);
    }
}
