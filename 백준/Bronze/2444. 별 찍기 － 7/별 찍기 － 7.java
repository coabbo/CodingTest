import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				System.out.print(" ");
			}
			for (int j = N*2 - i*2; j <= N*2; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		for (int i = 1; i <= N-1; i++) {
			for (int j = N-i; j <= N-1; j++) {
				System.out.print(" ");
			}
			for (int j = N*2 - i*2 - 1; j > 0; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}