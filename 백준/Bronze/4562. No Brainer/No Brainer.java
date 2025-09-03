import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int X = Integer.parseInt(st.nextToken()); // 좀비가 먹는 뇌의 수
            int Y = Integer.parseInt(st.nextToken()); // 좀비가 살아남기 위해 필요한 뇌의 수

            if(X >= Y) sb.append("MMM BRAINS").append("\n");
            else sb.append("NO BRAINS").append("\n");
        }

        System.out.println(sb.toString());
    }
}