import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		// 해당 대기번호의 관객에게 좌석을 배정할 수 없는 경우 0
		if (K > C * R) {
			System.out.println(0);
			return;
		}
		
		int[][] arr = new int[R][C]; // R행 C열
		int x = 0, y = R - 1; // 시작 위치 : 맨 왼쪽 아래 arr[R-1][0], x : 열 인덱스, y : 행 인덱스
		int dir = 0; // 방향 인덱스 : 0 : 위, 1 : 오른쪽, 2 : 아래, 3 : 왼쪽
		int[] dx = {0, 1, 0, -1}; // x축 변화량 : 상, 우, 하, 좌
		int[] dy = {-1, 0, 1, 0}; // y축 변화량 : 상, 우, 하, 좌
		int num = 1; // 배열에 채울 숫자
		
		while(true) {
			arr[y][x] = num;
			
			// 대기번호가 K인 관객에게 배정될 좌석번호
			if (num == K) {
				System.out.println((x + 1) + " " + (R - y));
				return;
			}
			
			num++;
			
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			// 경계를 넘어서거나 이미 방문했을 때 방향 전환
			if(nx < 0 || nx >= C || ny < 0 || ny >= R || arr[ny][nx] != 0) {
				dir = (dir + 1) % 4;
				// 새로운 nx, ny 다시 계산
				nx = x + dx[dir];
				ny = y + dy[dir];
			}
			
			// 좌표 이동
			x = nx;
			y = ny;
		}
	}
}