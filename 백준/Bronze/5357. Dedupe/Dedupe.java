import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			
			sb.append(s.charAt(0));
			for (int j = 1; j < s.length(); j++) {
				if (s.charAt(j-1) != s.charAt(j)) sb.append(s.charAt(j));
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}