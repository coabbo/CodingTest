import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N; // 행
	static int M; // 열
	static int[][] map; // 도화지
	static boolean[][] visited; // 방문 체크
	
	static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 도화지 정보 입력
		
		int pictureCount = 0; // 그림의 개수
		int maxArea = 0; // 가장 넓은 그림의 넓이
		
		// 전체 도화지를 순회하면서 아직 방문하지 않은 그림의 부분(1)을 찾음
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					pictureCount++; // 새로운 그림 발견
					int area = bfs(i, j); // 해당 그림의 면적 계산
					maxArea = Math.max(maxArea, area); // 최대 면적 갱신
				}
			}
		}
		
		System.out.println(pictureCount);
		System.out.println(maxArea);
	}

	// BFS 메소드 : 시작점 (r, c)에서 연결된 그림의 면적(칸 개수)를 반환
	public static int bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c}); //시작정점을 넣었다.
		visited[r][c] = true;
		int count = 1; // 시작 칸 포함
		
		while(!q.isEmpty()) {
			int[] curr = q.poll(); //값을 하나 꺼냄
			
			//4방향 탐색
			for(int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d]; //다음 좌표
				
				//1. 범위를 벗어났으면 쳐내
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
				//2. 그림의 일부분이 아니면 쳐내 / 이미 거리가 결정되어 있으면 쳐내
				if(map[nr][nc] == 0 || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
				count++;
			}
		}
		
		return count;
	}
}