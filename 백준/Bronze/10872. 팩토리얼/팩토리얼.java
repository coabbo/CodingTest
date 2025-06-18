import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int fact = 1;
		
		if(N > 0) {
			for (int i = 1; i <= N; i++) {
				fact *= i;
			}
		}
		
		System.out.println(fact);
	}
}