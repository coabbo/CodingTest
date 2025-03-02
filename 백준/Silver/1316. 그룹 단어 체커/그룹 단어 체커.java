import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        
        for (int t = 0; t < N; t++) {
            String word = br.readLine();
            boolean[] seen = new boolean[26];
            boolean isGroup = true;
            char prev = word.charAt(0);
            seen[prev - 'a'] = true;
            
            for (int i = 1; i < word.length(); i++) {
                char current = word.charAt(i);
                if (current != prev) {
                    if (seen[current - 'a']) {
                        isGroup = false;
                        break;
                    }
                    seen[current - 'a'] = true;
                }
                prev = current;
            }
            
            if (isGroup) answer++;
        }
        
        System.out.println(answer);
    }
}