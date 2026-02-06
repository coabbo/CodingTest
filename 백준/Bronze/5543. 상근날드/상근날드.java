import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a1 = Integer.parseInt(br.readLine());
		int a2 = Integer.parseInt(br.readLine());
		int a3 = Integer.parseInt(br.readLine());
		int[] a = {a1, a2, a3};
		
		int b1 = Integer.parseInt(br.readLine());
		int b2 = Integer.parseInt(br.readLine());
		int[] b = {b1, b2};
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			int temp = 0;
			
			for (int j = 0; j < b.length; j++) {
				temp = a[i] + b[j];
				min = Math.min(temp, min);
			}
		}
		
		System.out.println(min - 50);
	}
}