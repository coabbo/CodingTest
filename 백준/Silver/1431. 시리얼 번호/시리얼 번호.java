import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            list.add(br.readLine());
        }

        // Comparator를 사용해서 커스텀 정렬
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 1. 길이가 다르면 -> 길이 비교
                if (o1.length() != o2.length()) {
                    return Integer.compare(o1.length(), o2.length());
                }

                // 2. 길이가 같으면 -> 숫자 합으로 비교
                int sum1 = sumOfDigits(o1);
                int sum2 = sumOfDigits(o2);
                if (sum1 != sum2) {
                    return Integer.compare(sum1, sum2);
                }

                // 3. 숫자 합도 같으면 -> 사전순
                return o1.compareTo(o2);
            }
        });

        for (String s : list) {
            sb.append(s).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static int sumOfDigits(String s) {
        int sum = 0;
        for (char c : s.toCharArray()) {
            if(Character.isDigit(c)) {
                sum += c - '0';
            }
        }

        return sum;
    }
}