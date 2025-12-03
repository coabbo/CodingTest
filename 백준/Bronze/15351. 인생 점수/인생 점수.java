import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            int score = 0;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(c == ' ') continue;

                score += c - 'A' + 1;
            }

            if(score == 100) sb.append("PERFECT LIFE").append("\n");
            else sb.append(score).append("\n");
        }

        System.out.println(sb.toString());
    }
}