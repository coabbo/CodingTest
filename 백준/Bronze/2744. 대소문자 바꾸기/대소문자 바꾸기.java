import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) >= 65 && s.charAt(i) <= 90) {
				sb.append((char)(s.charAt(i) + 32));
			}
			else if(s.charAt(i) >= 97 && s.charAt(i) <= 122) {
				sb.append((char)(s.charAt(i) - 32));
			}
		}
		
		System.out.println(sb.toString());
	}
}