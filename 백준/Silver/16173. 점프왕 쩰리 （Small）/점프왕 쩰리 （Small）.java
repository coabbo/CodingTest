import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N; // 행, 열
	static int[][] map; // 점프 거리 정보
	static boolean[][] visited; // 방문 체크
	
	static int[] dr = {1, 0}; // 아래, 오른쪽 방향
	static int[] dc = {0, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 보드 정보 입력
		
		bfs(0, 0);
	}

	public static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c}); // 시작정점을 넣었다.
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll(); // 값을 하나 꺼냄
			int curR = curr[0];
			int curC = curr[1];
			
			//도착지점 도착
			if(curr[0] == N-1 && curr[1] == N-1) {
				System.out.println("HaruHaru");
				return;
			}
			
			int jump = map[curR][curC]; // 현재 칸에 적힌 점프 거리
			if(jump == 0) continue; // 0이면 더이상 이동 불가
			
			//오른쪽이나 아래 두 방향으로 점프
			for(int d = 0; d < 2; d++) {
				int nr = curR + jump * dr[d];
				int nc = curC + jump * dc[d]; //다음 좌표
				
				//1. 범위를 벗어났으면 쳐내
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				//2. 이미 방문되어 있으면 쳐내
				if(visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
		
		// BFS 종료 후 도착하지 못한 경우
		System.out.println("Hing");
	}
}