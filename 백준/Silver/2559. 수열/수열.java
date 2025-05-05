import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 온도를 측정한 전체 날짜의 수
		int K = Integer.parseInt(st.nextToken()); // 연속적인 날짜의 수
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 처음 K개의 합 계산
		int sum = 0;
		for (int i = 0; i < K; i++) {
			sum += arr[i];
		}
		int maxSum = sum;

		// 한 칸씩 슬라이드
		for (int i = K; i < N; i++) {
			
			sum -= arr[i-K]; // 제외된 값
			sum += arr[i]; // 새로 포함된 값
			
			maxSum = Math.max(maxSum, sum); // 최댓값 갱신
		}
		
		System.out.println(maxSum);
	}
}