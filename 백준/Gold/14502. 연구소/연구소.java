import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int M;
	private static int[][] map;
	private static int maxSafeZone = 0;
	
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
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
		
		// 1. 벽 3개 세우는 모든 경우를 탐색
		dfs(0);
		
		System.out.println(maxSafeZone);
	}

	public static void dfs(int wallCount) {
		// 2. 벽이 3개가 설치되면 bfs 시작
		if(wallCount == 3) {
			maxSafeZone = Math.max(maxSafeZone, bfs()); // 안정 영역 최댓값만 저장
			return;
		}
		
		// 모든 경우의 수를 다룸
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					dfs(wallCount + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	// 3. 바이러스 퍼뜨리기
	public static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		// 현재 바이러스 위치들을 큐에 넣음
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if(map[r][c] == 2) {
					q.add(new int[] {r, c});
				}
			}
		}
		
		// 원본 연구소를 바꾸지 않기 위해 연구소를 복제
		int tempMap[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tempMap[i][j] = map[i][j];
			}
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cr = curr[0];
			int cc = curr[1];
			
			for (int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				
				if(tempMap[nr][nc] == 0) {
					q.add(new int[] {nr, nc});
					tempMap[nr][nc] = 2;
				}
			}
		}
		
		// 4. 안전 영역 개수 세기
		int safeZone = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tempMap[i][j] == 0) safeZone++;
			}
		}
		
		return safeZone;
	}
}