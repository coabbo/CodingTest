import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 완탐, 시뮬레이션, 2차원배열 그래프, 그리디
 * BFS 큐
 */
public class Solution {
	private static int[] dr = {-1,-1,-1, 0, 0, 1, 1, 1}; // 좌상,상,우상,좌,우,좌하,하,우하
	private static int[] dc = {-1, 0, 1,-1, 1,-1, 0, 1};
	private static char[][] m;
	private static int[][] cnt;
	private static boolean [][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) { // 20개 테스트케이스
			int N = Integer.parseInt(br.readLine()); // 1 <= N <= 300
			m = new char[N+2][N+2]; // 외곽 한줄씩 빈공간 여분
			cnt = new int[N+2][N+2]; // 폭탄의 개수, 외곽 한줄씩 빈공간 여분 
			for (int r = 1; r <= N; r++) {
				String s = br.readLine();
				for (int c = 1; c <= N; c++) {
					m[r][c] = s.charAt(c-1); 
					if (m[r][c] == '*') { // 폭탄이면
						cnt[r][c] = '*'; // 사용하지 않는 숫자넣기
						for (int i = 0; i < dr.length; i++) {
							cnt[r+dr[i]][c+dc[i]]++;
						}
					}
				}
			}
	visited = new boolean[N+2][N+2]; // 방문여부    <------ 멤버변수 올리기
			// 외곽에 방문체크
			for (int i = 0; i < visited.length; i++) {
				visited[0][i] = visited[N+1][i] = visited[i][0] = visited[i][N+1] = true;
			}
			int result = 0; // 클릭 회수 카운팅 변수 int result = 0
			// 행우선순회 0인곳을 찾아서 클릭 BFS 탐색 시작 result++;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!visited[i][j] && cnt[i][j] == 0) { // 0인곳 미방문
						bfs(i, j); // 0인곳 주변 8방을 방문체크,0이면 또 큐에넣고 탐색
						result++;
					}
				}
			}
			// 행우선순회 1~8까지 열리지 않은 숫자를 카운팅
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!visited[i][j] && m[i][j] != '*') { // 폭탄아닌 미방문 숫자 카운팅
						result++;
					}
				}
			}
			sb.append('#').append(testCase).append(' ').append(result).append('\n');
		} // end of for testCase
		System.out.print(sb);
	} // end of main
	private static Queue<int[]> q = new LinkedList<int[]>(); // BFS FIFO
	/** 0인곳 주변 8방을 방문체크,0이면 또 큐에넣고 탐색 */
	public static void bfs(int r, int c) {
//		q.clear(); // 초기화
		visited[r][c] = true;
		q.offer(new int[] {r,c});
		while(q.size() > 0) { // 큐가 빌때까지
			int[] temp = q.poll();
			r = temp[0];
			c = temp[1];
			for (int i = 0; i < dr.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (visited[nr][nc]) continue; // 방문했으면 나가리
				visited[nr][nc] = true;
				if (cnt[nr][nc] == 0) {
					q.offer(new int[] {nr,nc});
				}
			}
		}
	}
} // end of class