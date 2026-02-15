import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String s = br.readLine();
			
			if(s.equals("0")) break;
			
			int answer = 1;
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '1') answer += 2;
				else if(s.charAt(i) == '0') {
					answer += 4;
				}
				else answer += 3;
				
				answer += 1;
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}