import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 플로이드 워샬
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
//			인접하지 않은 관계를 표시하기 위해 큰 값으로 초기화
			for (int i = 1; i < a.length; i++) {
				for (int j = 1; j < a.length; j++) {
					a[i][j] = 500;
				}
			}
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				int small = Integer.parseInt(st.nextToken());
				int tall = Integer.parseInt(st.nextToken());
				a[small][tall] = 1; // 단방향
			}
			
			for (int k = 1; k <= N; k++) { // 경유지
				for (int start = 1; start <= N; start++) { // 출발지
					if (k == start) continue; // 위 입력 시 if (i == j) map[i][j] = 0; 인 경우 코드를 생략할 수 있음, 생략해야 더 빠름
					for (int end = 1; end <= N; end++) { // 도착지
						if (k == end || start == end) continue; // 위 입력 시 if (i == j) map[i][j] = 0; 인 경우 코드를 생략할 수 있음, 생략해야 더 빠름
						if (a[start][end] > a[start][k] + a[k][end]) {
							a[start][end] = a[start][k] + a[k][end];
						}
//						a[start][end] = Math.min(a[start][k] + a[k][end], a[start][end]); // 빠름
					}
				}
			}
			
			for (int i = 1; i < a.length; i++) {
				for (int j = 1; j < a.length; j++) {
					if (a[j][i] < 500) a[0][i]++;
					if (a[i][j] < 500) a[i][0]++;
				}
			}
			
			int cnt = 0; // 자신의 순위를 정확히 알 수 있는 학생 수
			for (int i = 1; i < a.length; i++) {
				int sum = 0;
				for (int j = 1; j < a.length; j++) {
					if (a[j][i] < 500) sum++;
					if (a[i][j] < 500) sum++;
				}
				if (sum == N-1) { // 자신의 순위를 정확히 알 수 있으면 N-1
					cnt++;
				}
			}
			sb.append("#").append(testCase).append(" ").append(cnt).append("\n");
		} // end of for testCase
		System.out.println(sb.toString());
	} // end of main
} // end of class
