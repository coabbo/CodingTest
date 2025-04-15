import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N; // 행
	static int M; // 열
	static int[][] map; // 지도
	static int[][] dist; // 거리
	static boolean[][] check0; // 0 위치 체크
	
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		check0 = new boolean[N][M];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) {
					check0[i][j] = true;
				}
			}
		} // 지도 정보 입력
		
		int[][] ans = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 2) {
					ans = bfs(i, j);
				}
			}
		}
		
		// 도달할 수 없는 칸은 -1, 0인 칸은 0, 시작점(2)인 칸은 0, 그 외 칸은 최단거리 출력
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans[0].length; j++) {
				if(ans[i][j] == 0 && !check0[i][j]) {
					sb.append(-1).append(" "); 
				}
				else if(map[i][j] == 2) {
					sb.append(0).append(" "); 
				}
				else {
					sb.append(ans[i][j]).append(" "); 
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	// BFS 메소드 : 시작점 (r, c)에서 도달 가능한 모든 칸의 최단 거리를 구함
	public static int[][] bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c}); //시작정점을 넣었다.
		dist[r][c] = 0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll(); //값을 하나 꺼냄
			
			//4방향 탐색
			for(int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d]; //다음 좌표
				
				//1. 범위를 벗어났으면 쳐내
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				//2. 땅이 아니면 쳐내 / 이미 방문했으면 쳐내
				if(map[nr][nc] == 0 || dist[nr][nc] != 0) continue;
				
				dist[nr][nc] = dist[curr[0]][curr[1]] + 1;
				q.add(new int[] {nr, nc});
			}
		}
		
		return dist;
	}
}