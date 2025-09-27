import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < n; testCase++) {
			int x = Integer.parseInt(br.readLine());
			
			sb.append(x + " " + x).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}