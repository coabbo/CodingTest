import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken()); // 조카의 수
		int N = Integer.parseInt(st.nextToken()); // 과자의 수
		
		int[] cookie = new int[N];
		int maxLength = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < cookie.length; i++) {
			cookie[i] = Integer.parseInt(st.nextToken());
			
			if(maxLength < cookie[i]) {
				maxLength = cookie[i];
			}
		}
		
		long low = 1;
		long high = maxLength;
		long answer = 0;
		
		while(low <= high) {
			long mid = (low + high) / 2;
			long count = 0;
			
			for (int i = 0; i < cookie.length; i++) {
				if(cookie[i] >= mid) {
					count += cookie[i] / mid;
				}
			}
			
			if(M <= count) {
				answer = mid;
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		
		System.out.println(answer);
	}
}