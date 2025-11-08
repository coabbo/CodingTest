import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Character[][] arr = new Character[8][8];

        for (int i = 0; i < 8; i++) {
            String s = br.readLine();

            for (int j = 0; j < 8; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int count = 0;

        // 짝수 행 확인
        for (int i = 0; i < 8; i+=2) {
            for (int j = 0; j < 8; j+=2) {
                if(arr[i][j] == 'F') {
                    count++;
                }
            }
        }

        // 홀수 행 확인
        for (int i = 1; i < 8; i+=2) {
            for (int j = 1; j < 8; j+=2) {
                if(arr[i][j] == 'F') {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}