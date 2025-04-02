import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * dfs, 메모이제이션
 * 나보다 큰 부모를 찾아가서, 부모보다 큰 사람의 정보를 가져와서 내꺼에 업데이트
 */
public class Solution {
	
	private static int[][] a;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine()); // 1 <= TC <= 15
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine()); // 학생들 수, 2 <= N <= 500
			int M = Integer.parseInt(br.readLine()); // 비교 횟수, 0 <= M <= N*(N-1)/2
			a = new int[N+1][N+1]; // 0번 안 씀, 인접행렬
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int small = Integer.parseInt(st.nextToken());
				int tall = Integer.parseInt(st.nextToken());
				a[small][tall] = 1; // 단방향
			}
		
			for (int i = 0; i < a.length; i++) {
				up(i); // 정점보다 큰 정점들 탐색하면서 인접행렬 업데이트
			}
			
			int cnt = 0; // 자신의 순위를 정확히 알 수 있는 학ㄷ생 수
			for (int i = 1; i < a.length; i++) {
				int sum = 0; // 나보다 큰 친구, 작은 친구를 누적
				for (int j = 1; j < a.length; j++) {
					sum += a[i][j] + a[j][i];
				}
				if (sum == N-1) { // 자신의 순위를 정확하게 알 수 있음
					cnt++;
				}
			}
			
			sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
		} // end of for testCase
		System.out.println(sb.toString());
	} // end of main


	/** 나보다 큰 부모를 찾아가서, 부모보다 큰 사람의 정보를 가져와서 내꺼에 업데이트 */
	private static void up(int v) {
		if (a[v][0] == -1) return; // 작업완료 됨
		for (int i = 1; i < a.length; i++) {
			if(a[v][i] == 1) { // 나보다 큼
				up(i); //부모꺼는 업데이트 완료
				for (int j = 0; j < a.length; j++) { // 부모보다 큰 친구들을 내꺼에 업데이트
					a[v][j] |= a[i][j]; 
				}
			}
		}
		a[v][0] = -1; // 작업 완료 표시
	}
} // end of class
