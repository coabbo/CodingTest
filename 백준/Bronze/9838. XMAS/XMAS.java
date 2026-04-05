import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n + 1];
		
		int count = 1;
		for (int i = 0; i < n; i++) {
			int index = Integer.parseInt(br.readLine());
			arr[index] = count++;
		}
		
		for (int i = 1; i <= n; i++) {
			sb.append(arr[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}