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

            if(s.length() >= 6 && s.length() <= 9) {
                sb.append("yes").append("\n");
            }
            else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}