import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int M, N, H;
	private static int[][][] box;
	private static int[][][] day;
	private static boolean[][][] visited;
	
	// {dh, dr, dc} 순서로 위, 아래, 앞, 뒤, 왼쪽, 오른쪽
	private static int[][] dirs = {
			{-1, 0, 0}, {1, 0, 0},
			{0, -1, 0}, {0, 1, 0},
			{0, 0, -1}, {0, 0, 1}
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 가로 칸의 수
		N = Integer.parseInt(st.nextToken()); // 세로 칸의 수
		H = Integer.parseInt(st.nextToken()); // 상자의 수(높이)
		
		box = new int[H][N][M];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < M; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
		day = new int[H][N][M];
		visited = new boolean[H][N][M];
		
		bfs();
		
		int maxDay = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {

					if(box[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
					
					maxDay = Math.max(day[i][j][k], maxDay);
				}
			}
		}
		
		System.out.println(maxDay);
	}
	
	private static void bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		// 초기 큐에 모든 익은 토마토를 넣음(Multi Source BFS)
		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if(box[h][r][c] == 1) {
						q.add(new int[] {h, r, c});
						visited[h][r][c] = true;
						day[h][r][c] = 0;
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int ch = curr[0];
			int cr = curr[1];
			int cc = curr[2];
			
			for (int[] dir : dirs) {
				int nh = ch + dir[0];
				int nr = cr + dir[1];
				int nc = cc + dir[2];
				
				if(nh < 0 || nh >= H) continue;
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(box[nh][nr][nc] != 0 || visited[nh][nr][nc]) continue;
				
				q.add(new int[] {nh, nr, nc});
				visited[nh][nr][nc] = true; // 방문 표시
				box[nh][nr][nc] = 1; // 토마토 익힘
				day[nh][nr][nc] = day[ch][cr][cc] + 1; // 익는 날짜 기록
			}
		}
	}
}