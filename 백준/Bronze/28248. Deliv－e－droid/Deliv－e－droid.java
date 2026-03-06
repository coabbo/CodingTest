import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int P = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int answer = 0;
		answer += P * 50;
		answer -= C * 10;
		
		if (P > C) answer += 500;
		
		System.out.println(answer);
	}
}