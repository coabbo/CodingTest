import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static int[] arr;
	public static int[] combRes;
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
		for (int i = 1; i <= N; i++) {
			combRes = new int[i];
			comb(0, 0, i);
		}
		
		System.out.println(M - sumSet.size());
	}

	private static void comb(int start, int depth, int count) {
		if(depth == count) {
			int sum = 0;
			for (int i = 0; i < combRes.length; i++) {
				sum += combRes[i];
			}
			
			sumSet.add(sum);
			return;
		}
		
		for (int i = start; i < N; i++) {
			combRes[depth] = arr[i];
			comb(i + 1, depth + 1, count);
		}
	}
}