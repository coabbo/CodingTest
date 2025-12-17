import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int R;
	private static int C;
	private static int T;
	private static int[][] map;
	private static int airTop, airBottom; // 공기청정기 위치

	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		int airCount = 0;
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == -1 && airCount == 0) { // 공기청정기 위치 찾기
					airTop = i;
					airBottom = i + 1;
					
					airCount++;
				}
			}
		}
		
		// T초 동안 시뮬레이션
		for (int i = 0; i < T; i++) {
			spread(); // 1. 미세먼지 확산
			cleanAir(); // 2. 공기청정기 작동
		}
		
		// 남아있는 미세먼지의 양 구하기
		int sum = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == -1 || map[i][j] == 0) continue;
				
				sum += map[i][j];
			}
		}
		
		System.out.println(sum);
	}

	// 1. 미세먼지 확산
	private static void spread() {
		int[][] temp = new int[R][C];
		
		for (int r = 0; r < temp.length; r++) {
			for (int c = 0; c < temp[r].length; c++) {
				int amount = map[r][c] / 5;
				int count = 0;
				
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					
					if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
					if(map[nr][nc] == -1) continue;
					
					temp[nr][nc] += amount;
					count++;
				}
				
				map[r][c] -= amount * count;
			}
		}
		
		// temp 결과를 map에 반영
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] += temp[i][j];
			}
		}
	}
	
	// 2. 공기청정기 작동
	private static void cleanAir() {
		// 위쪽 (반시계 방향)
		// ↓ 왼쪽 열
		for(int i = airTop - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}
		
		// ← 위쪽 행
		for (int j = 0; j < C - 1; j++) {
			map[0][j] = map[0][j + 1];
		}
		
		// ↑ 오른쪽 열
		for (int i = 0; i < airTop; i++) {
			map[i][C - 1] = map[i + 1][C - 1];
		}
		
		// → 공기 청정기 행
		for (int j = C - 1; j > 1; j--) {
			map[airTop][j] = map[airTop][j - 1];
		}
		
		map[airTop][1] = 0;
		
		
		// 아래쪽 (시계 방향)
		// ↑ 왼쪽 열
		for (int i = airBottom + 1; i < R - 1; i++) {
			map[i][0] = map[i + 1][0];
		}
		
		// ← 아래쪽 행
		for (int j = 0; j < C - 1; j++) {
			map[R - 1][j] = map[R - 1][j + 1];
		}
		
		// ↓ 오른쪽 열
		for (int i = R - 1; i > airBottom; i--) {
			map[i][C - 1] = map[i - 1][C - 1];
		}
		
		// → 공기 청정기 행
		for (int j = C - 1; j > 1; j--) {
			map[airBottom][j] = map[airBottom][j - 1];
		}
		
		map[airBottom][1] = 0;
	}
}