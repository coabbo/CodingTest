import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            String order = st.nextToken();
            int end = Integer.parseInt(st.nextToken());

            if((start + " " + order + " " + end).equals("0 W 0")) {
                break;
            }

            if(order.equals("W")) {
                if(start - end < -200) {
                    sb.append("Not allowed").append("\n");
                }
                else {
                    sb.append(start - end).append("\n");
                }
            }

            if(order.equals("D")) {
                sb.append(start + end).append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}