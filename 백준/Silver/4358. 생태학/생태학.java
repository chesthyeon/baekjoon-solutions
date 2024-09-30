import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        String species;
        int totalTrees = 0;

        while ((species = br.readLine()) != null && !species.isEmpty()) {
            treeMap.put(species, treeMap.getOrDefault(species, 0) + 1);
            totalTrees++;
        }

        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            double percentage = (entry.getValue() * 100.0) / totalTrees;
            bw.write(entry.getKey() + " " + String.format("%.4f", percentage) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}