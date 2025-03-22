import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		int answer = 0;
		
		int count = 0;
		
		for (int i = 0; i < L; i++) {
			answer += (S.charAt(i) - 96) * Math.pow(31, count++);
		}
		
		System.out.println(answer);
	}
}