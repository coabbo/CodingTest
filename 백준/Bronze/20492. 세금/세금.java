import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int A = (int)(N * 0.78);
		int B = (int)(N * 0.8);
		
		sb.append(A).append(" ").append((int)(B + (N - B) * 0.78));
		
		System.out.println(sb.toString());
	}
}