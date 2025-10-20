import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> book = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            book.put(title, book.getOrDefault(title, 0) + 1);
        }

        List<String> keySet = new ArrayList<>(book.keySet());
        Collections.sort(keySet);

        int maxCount = 0;
        String maxBook = "";
        for (String key : keySet) {
            if(book.get(key) > maxCount) {
                maxCount = book.get(key);
                maxBook = key;
            }
        }

        System.out.println(maxBook);
    }
}