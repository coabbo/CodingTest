import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			int count = 0;
			String s = br.readLine();
			
			if(s.equals("#")) break;
			
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == ('A') || s.charAt(i) == ('a')) {
					count++;
				}
				else if(s.charAt(i) == ('E') || s.charAt(i) == ('e')) {
					count++;
				}
				else if(s.charAt(i) == ('I') || s.charAt(i) == ('i')) {
					count++;
				}
				else if(s.charAt(i) == ('O') || s.charAt(i) == ('o')) {
					count++;
				}
				else if(s.charAt(i) == ('U') || s.charAt(i) == ('u')) {
					count++;
				}
			}
			
			sb.append(count).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}