import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(br.readLine());
		for (int i = 0; i < C; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int count = 0;
			for (int j = 1; j <= n; j++) {
				if(n % j == 0) count++;
			}
			
			sb.append(n).append(" ").append(count).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}