import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                count++;
            }
        }

        System.out.println(count);
    }
}