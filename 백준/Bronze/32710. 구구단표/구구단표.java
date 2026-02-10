import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
A:		for (int i = 2; i <= 9; i++) {
			int temp = 0;
			
			for (int j = 1; j <= 9; j++) {
				temp = i * j;
				
				if(N == temp || N == i || N == j) {
					answer = 1;
					break A;
				}
			}
		}
		
		System.out.println(answer);
	}
}