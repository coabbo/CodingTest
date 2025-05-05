import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // 수열의 길이
		int S = Integer.parseInt(st.nextToken()); // 이상으로 만들고자 하는 값
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 슬라이딩 윈도우
		// end로 구간을 확장하고, sum >= S가 될 때마다
		// start를 옮겨가며(구간을 축소) 최소 길이를 갱신한다.
		int minLen = Integer.MAX_VALUE;
		int sum = 0;
		int start = 0;
		for (int end = 0; end < arr.length; end++) {
			sum += arr[end];
			
			while(sum >= S) {
				minLen = Math.min(minLen, end - start + 1);
				sum -= arr[start];
				start++;
			}
		}
		
		System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
	}
}
