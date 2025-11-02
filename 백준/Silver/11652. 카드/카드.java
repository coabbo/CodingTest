import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());

        Long answer = Long.MAX_VALUE;
        for(Map.Entry<Long, Integer> entry : map.entrySet()) {
            if(entry.getValue() == list.get(0)) {
                if(entry.getKey() < answer) {
                    answer = entry.getKey();
                }
            }
        }

        System.out.println(answer);
    }
}