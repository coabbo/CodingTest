import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int winner = 0;
        int maxScore = 0;

        for (int i = 1; i <= 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int x3 = Integer.parseInt(st.nextToken());
            int x4 = Integer.parseInt(st.nextToken());

            int currScore = x1 + x2 + x3 + x4;

            if(maxScore < currScore) {
                winner = i;
                maxScore = currScore;
            }
        }

        System.out.println(winner + " " + maxScore);
    }
}