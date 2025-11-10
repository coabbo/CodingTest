import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");

            while(st.hasMoreTokens()) {
                StringBuilder temp = new StringBuilder();

                temp.append(st.nextToken());
                sb.append(temp.reverse()).append(" ");

                temp.setLength(0);
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}