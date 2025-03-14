import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int result = 1;
		
		result = fib(N);
		
		sb.append(result);
		System.out.println(sb.toString());
	}

	private static int fib(int n) {
		if(n <= 1) {
			return n;
		}
		
		return fib(n-1) + fib(n-2);
	}
}