import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String findS = br.readLine();

        int count = 0;
        int length = findS.length();
        for (int i = 0; i <= s.length() - length; i++) {
            String temp = s.substring(i, i + length);

            if(findS.equals(temp)) {
                count++;
                i += length - 1;
            }
        }

        System.out.println(count);
    }
}