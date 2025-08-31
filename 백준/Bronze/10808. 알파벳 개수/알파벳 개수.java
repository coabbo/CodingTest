import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String S = br.readLine();
		
		int[] a = new int[26];
		for (int i = 0; i < S.length(); i++) {
			a[S.charAt(i) - 'a']++;
		}
		
		for (int i : a) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}