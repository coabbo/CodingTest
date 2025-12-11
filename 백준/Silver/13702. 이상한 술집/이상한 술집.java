import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int K;
	private static long[] capacity;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 막걸리 주전자의 개수
		K = Integer.parseInt(st.nextToken()); // 본인 포함 친구들의 수
		
		capacity = new long[N];
		for (int i = 0; i < capacity.length; i++) {
			capacity[i] = Long.parseLong(br.readLine());
		}
		Arrays.sort(capacity);
		
		binarySearch();
	}

	private static void binarySearch() {
		long low = 1;
		long high = capacity[N-1];
		
		long answer = low;
		
		while(low <= high) {
			long mid = (low + high) / 2;

			if(check(mid)) {
				answer = mid;
				low = mid + 1;
			}
			else {
				high = mid - 1;
			}
		}
		
		System.out.println(answer);
	}

	private static boolean check(long mid) {
		int person = 0;
		
		for (int i = 0; i < capacity.length; i++) {
			person += capacity[i] / mid;
		}
		
		return person >= K;
	}
}