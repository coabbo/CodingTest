import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < N; testCase++) {
            String s = br.readLine();

            for (int i = 0; i < s.length(); i++) {
                if(i == 0) {
                    sb.append(Character.toUpperCase(s.charAt(i)));
                }
                else {
                    sb.append(s.charAt(i));
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}