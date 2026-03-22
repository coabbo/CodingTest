import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[K+1];
		for (int i = 1; i <= K; i++) {
			long num = N * i;
			
			long reverseNum = 0;
			while (num != 0) {
				reverseNum = reverseNum * 10 + num % 10;
				num /= 10;
			}
			
			arr[i-1] = reverseNum;
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[K]);
	}
}