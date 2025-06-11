import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 수열의 길이
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 1;
		int plusLen = 1;
		int minusLen = 1;
		
		for (int i = 1; i < N; i++) {
			// 연속해서 커지는 수열의 길이 체크
			if (arr[i-1] <= arr[i]) {
				plusLen++;
			}
			else {
				plusLen = 1;
			}
			
			// 연속해서 작아지는 수열의 길이 체크
			if(arr[i-1] >= arr[i]) {
				minusLen++;
			}
			else {
				minusLen = 1;
			}
			
			answer = Math.max(answer, Math.max(plusLen, minusLen));
		}
		
		System.out.println(answer);
	}
}