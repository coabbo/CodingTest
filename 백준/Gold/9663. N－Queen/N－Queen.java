import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	private static int N;
	private static boolean[][] m;
	private static int cnt;
	private static boolean[] flagCol;
	private static boolean[] flagRUp;
	private static boolean[] flagLUp;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		m = new boolean[N][N];
		cnt = 0;
		flagCol = new boolean[N]; // 가로
		flagRUp = new boolean[2*N-1]; // 우상 대각선
		flagLUp = new boolean[2*N-1]; // 좌상 대각선
		
		dfs(0);
		System.out.println(cnt);	
	}

	/** 한 row에 한 Queen을 놓아보기 */
	public static void dfs(int row) { // 0 ~ N-1
		if(row == N) { // 종료파트
			cnt++;
			return;
		}
		// 재귀파트
		for (int col = 0; col < N; col++) { // 0 ~ N-1
			if(check(row, col)) { // (row, col) 퀸을 놓아도 이전 퀸들과 서로 공격하지 않는가?
				m[row][col] = true;
				flagCol[col] = true;
				flagRUp[row+col] = true;
				flagLUp[row-col+N-1] = true;
				
				dfs(row+1);
				
				m[row][col] = false;
				flagCol[col] = false;
				flagRUp[row+col] = false;
				flagLUp[row-col+N-1] = false;
			}
		}
	}

	/** (row, col) 퀸을 놓아도 이전 퀸들과 서로 공격하지 않는가? 안싸우면 true / 싸우면 false */
	public static boolean check(int row, int col) {
		if (flagCol[col]) return false;
		if (flagRUp[row+col]) return false;
		if (flagLUp[row-col+N-1]) return false;
		return true;
	}
}