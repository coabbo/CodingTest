import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		
		int[] num = new int[N];
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(num);
		
		for (int i : num) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}