import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static int[][] map; //2자원 배열, 미로
	static int[][] dist; //방문 체크
	
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		dist = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		} //미로 입력
		
		int ans = bfs(0, 0);
		
		System.out.println(ans);
	}

	public static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c}); //시작정점을 넣었다.
		
		dist[r][c] = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll(); //값을 하나 꺼냄
			
			//도착 지점에 도달
			if(curr[0] == N-1 && curr[1] == M-1) {
				return dist[curr[0]][curr[1]];
			}
			
			//4방향 탐색
			for(int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d]; //다음 좌표
				
				//1. 범위 쳐내
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				//2. 벽이면 쳐내 / 이미 거리가 결정되어 있으면 쳐내
				if(map[nr][nc] == 0 || dist[nr][nc] != 0) continue;
				
				dist[nr][nc] = dist[curr[0]][curr[1]] + 1;
				q.add(new int[] {nr, nc});
			}
		}
		
		return -1; //탈출 못해~
	}
}