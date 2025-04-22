import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main {

	public static int N;
	public static int[][] map;
	public static boolean[][] visited;
	public static ArrayList<Integer> answerList;
	
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		answerList = new ArrayList<>(); //단지내 집의 수 리스트
		int count = 0; //총 단지수
		
		for (int i = 0; i < map.length; i++) {
			String s = br.readLine();
			for (int j = 0; j < map[0].length; j++) {
				map[i][j] = s.charAt(j) - 48;
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
					count += 1;
				}
			}
		}

		System.out.println(count);
		Collections.sort(answerList);
		for (int i = 0; i < answerList.size(); i++) {
			System.out.println(answerList.get(i));
		}
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c});
		visited[r][c] = true;
		int tmp = 1;
		
		while(!q.isEmpty()) {
			
			int[] curr = q.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = curr[0] + dr[d];
				int nc = curr[1] + dc[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(map[nr][nc] == 0 || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
				tmp += 1;
			}
		}
		answerList.add(tmp);
	}
}