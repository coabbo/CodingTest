import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		int MOD = 1234567891;
		String S = br.readLine();
		
		long answer = 0;		
		long count = 1;
		
		for (int i = 0; i < L; i++) {			
			answer = (answer + (S.charAt(i) - 96) * count) % MOD;
			count = (count * 31) % MOD;
		}
		
		System.out.println(answer);
	}
}