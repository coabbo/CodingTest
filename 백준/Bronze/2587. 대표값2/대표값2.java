import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] num = new int[5];
		
		for (int i = 0; i < 5; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		
		int sum = 0;
		
		Arrays.sort(num);
		
		for (int i = 0; i < num.length; i++) {
			sum += num[i];
		}
		
		System.out.println(sum / 5);
		System.out.println(num[2]);	
	}
}