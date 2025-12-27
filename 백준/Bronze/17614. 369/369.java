import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int count = 0;
		for (int i = 1; i <= N; i++) {
			String s = String.valueOf(i);
			
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == '3' || s.charAt(j) == '6' || s.charAt(j) == '9') count++;
			}
		}
		
		System.out.println(count);
	}
}