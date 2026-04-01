import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		String answer = "";
		int index = 0;
		while(true) {
			char c = s.charAt(index);
			
			if (c == '.') break;
			
			answer += c;
			index++;
		}
		
		System.out.println(answer);
	}
}