import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // DNA의 수
        int M = Integer.parseInt(st.nextToken()); // 문자열의 길이
        char[][] arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        String DNA = "";
        int hammingDistance = 0;
        for (int i = 0; i < M; i++) {
            String[] s = new String[] {"A", "C", "G", "T"};
            int[] count = new int[4]; // "A", "C", "G", "T" 순서

            // 1. 개수 세기
            for (int j = 0; j < N; j++) {
                if(arr[j][i] == 'A') count[0]++;
                else if(arr[j][i] == 'C') count[1]++;
                else if(arr[j][i] == 'G') count[2]++;
                else if(arr[j][i] == 'T') count[3]++;
            }

            // 2. Hamming Distance의 합이 가장 작은 DNA 만들기
            int temp = 0;
            String tempS = "";
            for (int j = 0; j < 4; j++) {
                if(temp < count[j]) {
                    temp = count[j];
                    tempS = s[j];
                }

                if(j == 3) {
                    hammingDistance += N - temp;
                    DNA += tempS;
                }
            }
        }

        System.out.println(DNA);
        System.out.println(hammingDistance);
    }
}