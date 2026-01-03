import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[][] map;
	
	private static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	private static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = bfs();
		System.out.println(answer);
	}
	
	public static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		int[][] dist = new int[N][M];
		
		// 1. 모든 상어 위치를 큐에 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					q.add(new int[] {i, j});
					dist[i][j] = 0;
				}
				else {
					dist[i][j] = -1; // 방문 안 함
				}
			}
		}
		
		// 2. BFS
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int d = 0; d < 8; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				if(dist[nr][nc] != -1) continue;
				
				q.add(new int[] {nr, nc});
				dist[nr][nc] = dist[cr][cc] + 1;
			}
		}
		
		// 3. 최대 거리 찾기
		int answer = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				answer = Math.max(answer, dist[i][j]);
			}
		}
		
		return answer;
	}
}