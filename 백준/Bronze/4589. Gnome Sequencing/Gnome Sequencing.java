import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        sb.append("Gnomes:").append("\n");

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A > B && B > C) {
                sb.append("Ordered").append("\n");
            }
            else if (A < B && B < C) {
                sb.append("Ordered").append("\n");
            }
            else {
                sb.append("Unordered").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}