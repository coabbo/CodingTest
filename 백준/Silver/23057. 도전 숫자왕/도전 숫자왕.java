import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] arr;
	public static Set<Integer> sumSet;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 카드의 개수
		
		int M = 0; // 모든 카드에 적힌 수의 합
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			M += arr[i];
		}
		
		sumSet = new HashSet<>();
		subset(0, 0);
		
		System.out.println(M - sumSet.size());
	}

	private static void subset(int idx, int sum) {
		if(idx == N) {
			if(sum > 0) sumSet.add(sum);
			return;
		}
		
		// 안 고른 경우
		subset(idx + 1, sum);
		
		// 고른 경우
		subset(idx + 1, sum + arr[idx]);
	}
}