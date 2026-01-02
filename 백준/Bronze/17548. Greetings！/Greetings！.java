import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			
			if(s.charAt(i) == 'e') {
				sb.append('e');
			}
			
		}
		
		System.out.println(sb.toString());
	}
}