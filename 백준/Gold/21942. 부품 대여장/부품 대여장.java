import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        String L = st.nextToken();
        int F = Integer.parseInt(st.nextToken());

        String[] LParts = L.split("/");
        Duration lendDuration = Duration.ofDays(Integer.parseInt(LParts[0]))
                .plusHours(Integer.parseInt(LParts[1].split(":")[0]))
                .plusMinutes(Integer.parseInt(LParts[1].split(":")[1]));

        Map<String, Map<String, LocalDateTime>> lendInfo = new HashMap<>();
        Map<String, Long> fines = new HashMap<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String date = st.nextToken();
            String time = st.nextToken();
            String item = st.nextToken();
            String member = st.nextToken();

            LocalDateTime dateTime = LocalDateTime.parse(date + " " + time, formatter);

            if (!lendInfo.containsKey(member)) {
                lendInfo.put(member, new HashMap<>());
            }

            if (lendInfo.get(member).containsKey(item)) {
                LocalDateTime lendDateTime = lendInfo.get(member).get(item);
                Duration actualDuration = Duration.between(lendDateTime, dateTime);

                if (actualDuration.compareTo(lendDuration) > 0) {
                    long overMinutes = actualDuration.toMinutes() - lendDuration.toMinutes();
                    long fine = overMinutes * F;
                    fines.put(member, fines.getOrDefault(member, 0L) + fine);
                }

                lendInfo.get(member).remove(item);
            } else {
                lendInfo.get(member).put(item, dateTime);
            }
        }

        List<String> sortedMembers = new ArrayList<>(fines.keySet());
        Collections.sort(sortedMembers);

        StringBuilder sb = new StringBuilder();
        if (fines.isEmpty()) {
            sb.append("-1\n");
        } else {
            for (String member : sortedMembers) {
                sb.append(member).append(" ").append(fines.get(member)).append("\n");
            }
        }

        System.out.print(sb.toString());
        br.close();
    }
}