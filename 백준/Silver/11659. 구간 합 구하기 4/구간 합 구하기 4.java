import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); //수의 개수
		int M = Integer.parseInt(st.nextToken()); //합을 구해야 하는 횟수
		
		long[] num = new long[N+1];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			num[i] = num[i-1] + Long.parseLong(st.nextToken());
		}
		
		//구간합 구하기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			long result = num[end] - num[start-1];
			System.out.println(result);
		}
		
	}
}