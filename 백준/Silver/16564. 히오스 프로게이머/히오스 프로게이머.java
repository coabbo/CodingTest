import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N, K;
	private static int[] level;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // 캐릭터의 개수
		K = Integer.parseInt(st.nextToken()); // 올릴 수 있는 레벨 총합
		
		level = new int[N];
		for (int i = 0; i < N; i++) {
			level[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(level);
		
		binarySearch();
	}

	public static void binarySearch() {
		int low = level[0];
		int high = level[N-1] + K;
		
		int answer = low;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			if(check(mid)) {
				answer = mid; // mid는 가능 -> 더 크게 해보기
				low = mid + 1;
			}
			else {
				high = mid - 1; // mid는 불가능해서 줄여야 함.
			}
		}
		
		System.out.println(answer);
	}
	
	public static boolean check(int T) {
		long need = 0;
		
		for (int i = 0; i < N; i++) {
			if(level[i] < T) {
				need += (T - level[i]);
				if (need > K) return false; // 올릴 수 있는 범위를 초과하면 못 만듦
			}
		}
		
		return need <= K;
	}
}