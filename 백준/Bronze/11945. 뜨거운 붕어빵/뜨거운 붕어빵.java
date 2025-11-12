import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            StringBuilder temp = new StringBuilder();

            String s = br.readLine();
            temp.append(s);
            temp.reverse();
            sb.append(temp.toString()).append("\n");

            temp.setLength(0);
        }

        System.out.println(sb.toString());
    }
}