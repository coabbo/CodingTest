import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int result = N / 5;
		result += N / 25;
		result += N / 125;
		
		sb.append(result);
		System.out.println(sb.toString());
	}
}