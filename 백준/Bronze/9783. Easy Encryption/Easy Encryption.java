import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int num = 0;
			
			if(c >= 'a' && c <= 'z') {
				num = c - 'a' + 1;
				
				if(num < 10) sb.append("0");
				sb.append(num);
			}
			else if(c >= 'A' && c <= 'Z') {
				num = c - 'A' + 27;
				sb.append(num);
			}
			else if(c >= '0' && c <= '9') {
				sb.append("#").append(c);
			}
			else {
				sb.append(c);
			}
			
		}
		
		System.out.println(sb.toString());
	}
}