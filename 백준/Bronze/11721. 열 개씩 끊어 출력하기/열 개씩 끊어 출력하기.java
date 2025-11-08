import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		for (int i = 0; i < s.length(); i += 10) {
			if(s.length() <= i + 10) {
				sb.append(s.substring(i)).append("\n");
				break;
			}
			
			sb.append(s.substring(i, i + 10)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}