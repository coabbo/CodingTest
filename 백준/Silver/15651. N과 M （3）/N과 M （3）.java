import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** N과 M (3) : 1부터 N까지 자연수 중에서 중복을 허용하고 순서를 고려해 M개를 고르는 중복순열 문제 */
public class Main {
	
	private static int N;
	private static int M;
	private static int[] result;
	private static boolean[] visited;
	private static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		visited = new boolean[N];
		
		permperm(0);
		
		System.out.println(sb.toString());
	}

	
	private static void permperm(int idx) {
		
		//종료조건
		if(idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		//재귀조건
		for (int i = 0; i < N; i++) {
			result[idx] = i + 1;
			visited[i] = true; // 사용했어!
			permperm(idx+1);
			visited[i] = false; // 원상복구
		}
	}
}