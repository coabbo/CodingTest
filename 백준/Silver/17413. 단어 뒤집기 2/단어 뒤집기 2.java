import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder answer = new StringBuilder();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '<') {
                sb.append(S.charAt(i));

                for(int j = i + 1; j < S.length(); j++) {
                    if(S.charAt(j) == '>') {
                        sb.append(S.charAt(j));
                        i = j;
                        break;
                    }
                    else {
                        sb.append(S.charAt(j));
                    }
                }
            }
            else {
                sb.append(S.charAt(i));

                for (int j = i + 1; j < S.length(); j++) {
                    if(S.charAt(j) == '<') {
                        sb.reverse();
                        i = j - 1;
                        break;
                    }

                    if(S.charAt(j) == ' ') {
                        sb.reverse();
                        sb.append(" ");
                        i = j;
                        break;
                    }

                    if(j == S.length() - 1) {
                        sb.append(S.charAt(j));
                        sb.reverse();
                        i = j;
                        break;
                    }

                    sb.append(S.charAt(j));
                }
            }

            answer.append(sb.toString());

            sb.setLength(0); // 내용 지우기
        }

        System.out.println(answer.toString());
    }
}