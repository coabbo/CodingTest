import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s;
		
		while ((s = br.readLine()) != null) {
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == 'i') {
					sb.append("e");
				}
				else if(s.charAt(j) == 'e') {
					sb.append("i");
				}
				else if(s.charAt(j) == 'I') {
					sb.append("E");
				}
				else if(s.charAt(j) == 'E') {
					sb.append("I");
				}
				else sb.append(s.charAt(j));
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}