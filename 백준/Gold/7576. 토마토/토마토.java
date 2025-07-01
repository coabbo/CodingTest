import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int M;
	private static int N;
	private static int[][] box;
	private static int[][] day;
	private static boolean[][] visited;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 가로 칸의 수
		N = Integer.parseInt(st.nextToken()); // 세로 칸의 수
		
		box = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		day = new int[N][M];
		visited = new boolean[N][M];
		bfs();
		
		int maxDay = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if(box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				
				maxDay = Math.max(day[i][j], maxDay);
			}
		}
		
		System.out.println(maxDay);
	}

	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		// 초기 큐에 모든 익은 토마토를 넣는다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(box[i][j] == 1) {
					q.add(new int[] {i, j});
					visited[i][j] = true;
					day[i][j] = 0;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(box[nr][nc] != 0 || visited[nr][nc]) continue;
				
				q.add(new int[] {nr, nc});
				visited[nr][nc] = true;
				box[nr][nc] = 1;
				day[nr][nc] = day[cr][cc] + 1;
			}
		}
	}
}