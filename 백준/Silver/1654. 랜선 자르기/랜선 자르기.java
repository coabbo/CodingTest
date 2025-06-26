import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int K = Integer.parseInt(st.nextToken()); // 이미 가지고 있는 랜선의 개수
		int N = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
		
		int[] LAN = new int[K];
		int maxLength = 0;
		for (int i = 0; i < LAN.length; i++) {
			LAN[i] = Integer.parseInt(br.readLine());
			
			if(maxLength < LAN[i]) {
				maxLength = LAN[i];
			}
		}
		
		long low = 1;
		long high = maxLength;
		long answer = 0;
		
		while(low <= high) {
			
			long mid = (low + high) / 2;
			int count = 0;
			
			for (int i = 0; i < LAN.length; i++) {
				count += LAN[i] / mid;
			}
			
			if(count >= N) {
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