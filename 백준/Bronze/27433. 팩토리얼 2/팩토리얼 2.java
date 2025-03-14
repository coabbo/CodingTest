import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		long result = 1;
		
		result = fact(N);
		
		sb.append(result);
		System.out.println(sb.toString());
	}

	private static long fact(int n) {
		if(n == 0) {
			return 1;
		}
		
		return n * fact(n-1);
	}
}