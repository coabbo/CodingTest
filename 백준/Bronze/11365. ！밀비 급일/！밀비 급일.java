import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringBuilder temp = new StringBuilder();
            String s = br.readLine();

            if(s.equals("END")) {
                break;
            }

            temp.append(s);
            sb.append(temp.reverse()).append("\n");
            temp.setLength(0);
        }

        System.out.println(sb.toString());
    }
}