import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		long n = 20000303;
		
		long answer = 0;
		for (int i = 0; i < N.length(); i++) {
			answer = (answer * 10 + (N.charAt(i) - '0')) % n;
		}
		
		System.out.println(answer);
	}
}