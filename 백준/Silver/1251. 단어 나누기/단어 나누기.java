import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int L = s.length();
        List<String> list = new ArrayList<>();

        for (int i = 1; i <= L - 2; i++) {
            for(int j = i + 1; j <= L - 1; j++) {
                String partA = s.substring(0, i);
                String partB = s.substring(i, j);
                String partC = s.substring(j, L);

                String reversedA = new StringBuilder(partA).reverse().toString();
                String reversedB = new StringBuilder(partB).reverse().toString();
                String reversedC = new StringBuilder(partC).reverse().toString();

                String newWord = reversedA + reversedB + reversedC;
                list.add(newWord);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }
}