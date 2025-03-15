import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** N과 M(1) : 1부터 N까지 자연수 중에서 중복 없이 순서를 고려해 M개를 고르는 순열(permutation) 문제 */
public class Main {

	private static int N; // 1부터 N까지의 자연수
	private static int M; // 중복 없이 M개를 고를 예정
	private static int[] result; // 결과 배열
	private static boolean[] visited; // 방문 체크
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		result = new int[M];
		visited = new boolean[N+1];
		
		perm(0);
	}

	// idx : 현재까지 선택된 원소의 개수
	public static void perm(int idx) {
		// 기저 조건
		if(idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(result[i] + " ");
			}
			System.out.println("");
			return;
		}
		
		// 재귀 부분
		for (int i = 1; i <= N; i++) {
			
			// 사용했으면 쳐내기
			if(visited[i]) {
				continue;
			}
			
			result[idx] = i;
			visited[i] = true; // 사용했어!
			perm(idx + 1);
			visited[i] = false; // 원상복구
		}
	}
}