import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int[] f;
	private static int f1Count = 0;
	private static int f2Count = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		f = new int[n + 1];
		
		fib(n);
		fibonacci(n);
		
		System.out.println(f1Count + " " + f2Count);
	}
	
	public static int fib(int n) {		
		if (n == 1 || n == 2) {
			f1Count++;
			return 1;
		}
		else {
			return (fib(n-1) + fib(n-2));
		}
	}
	
	public static int fibonacci(int n) {
		f[1] = 1;
		f[2] = 1;
		for (int i = 3; i <= n; i++) {
			f2Count++;
			f[i] = f[i-1] + f[i-2];
		}
		
		return f[n];
	}
}