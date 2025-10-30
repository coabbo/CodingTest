import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String target = "UCPC";
        int targetIndex = 0; // (0: U, 1: C, 2: P, 3: C)

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == target.charAt(targetIndex)) {
                targetIndex++;
            }

            if(targetIndex == 4){
                System.out.print("I love UCPC");
                return;
            }
        }

        System.out.print("I hate UCPC");
    }
}