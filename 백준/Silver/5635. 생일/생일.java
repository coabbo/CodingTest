import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] birth = new String[n][2];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] temp = s.split(" ");

            String year = temp[3];

            String month = "";
            if(Integer.parseInt(temp[2]) < 10) {
                month += "0" + temp[2];
            }
            else {
                month = temp[2];
            }

            String day = "";
            if(Integer.parseInt(temp[1]) < 10) {
                day += "0" + temp[1];
            }
            else {
                day = temp[1];
            }

            birth[i][0] = temp[0];
            birth[i][1] = year + month + day;
        }

        int maxBirth = Integer.MIN_VALUE;
        String maxName = "";
        int minBirth = Integer.MAX_VALUE;
        String minName = "";
        
        for (int i = 0; i < n; i++) {
            if(maxBirth < Integer.parseInt(birth[i][1])) {
                maxBirth = Integer.parseInt(birth[i][1]);
                maxName = birth[i][0];
            }

            if(minBirth > Integer.parseInt(birth[i][1])) {
                minBirth = Integer.parseInt(birth[i][1]);
                minName = birth[i][0];
            }
        }

        System.out.println(maxName);
        System.out.println(minName);
    }
}