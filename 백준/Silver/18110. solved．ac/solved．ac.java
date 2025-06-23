import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 난이도 의견의 개수
		
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int cut = (int) Math.round(n * 0.15);
		double mean = 0;
		for (int i = cut; i < arr.length - cut; i++) {
			mean += arr[i];
		}
		mean /= n - (2 * cut);
		
		System.out.println(Math.round(mean));
	}
}