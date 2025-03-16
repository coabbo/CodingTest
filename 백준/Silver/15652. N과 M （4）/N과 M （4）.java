import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** N과 M (4) : 1부터 N까지 자연수 중에서 중복을 허용하고 순서에 상관 없이 M개를 고르는 중복조합 문제 */
public class Main {
	
	private static int N;
	private static int M;
	private static int[] result;
	private static int[] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		visited = new int[N];
		
		int temp = 0;
		for (int i = 1; i <= N; i++) {
			visited[temp++] = i;
		}
		
		combcomb(0, 0);
		
		System.out.println(sb.toString());
	}

	
	// idx : 이번에 고려할 인덱스
	// sidx : 뽑은 인덱스
	private static void combcomb(int idx, int sidx) {
		
		//종료조건
		if(sidx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//재귀조건
		for (int i = idx; i < N; i++) {
			result[sidx] = visited[i];
			combcomb(i, sidx+1);
		}
	}
}