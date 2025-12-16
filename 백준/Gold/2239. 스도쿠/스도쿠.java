import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private static int[][] map;
	private static List<int[]> empty;
	private static StringBuilder sb;
	private static boolean solved;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		map = new int[9][9];
		empty = new ArrayList<>(); // 숫자가 채워지지 않은 칸 저장용 리스트
		
		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			
			for (int j = 0; j < 9; j++) {
				map[i][j] = s.charAt(j) - '0';
				
				if(map[i][j] == 0) empty.add(new int[] {i, j});
			}
		}
		
		dfs(0);
	}

	public static void dfs(int idx) {
		if(solved) return;
		
		if(idx == empty.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]);
				}
				
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
			solved = true;
			
			return;
		}
		
		int[] curr = empty.get(idx);
		int currR = curr[0];
		int currC = curr[1];
		
		for (int i = 1; i <= 9; i++) {
			if(check(currR, currC, i)) {
				map[currR][currC] = i;
				dfs(idx + 1);
				map[currR][currC] = 0;
			}
		}
	}

	public static boolean check(int r, int c, int num) {
		// 행 검사
		for (int col = 0; col < 9; col++) {
			if(map[r][col] == num) return false;
		}
		
		// 열 검사
		for (int row = 0; row < 9; row++) {
			if(map[row][c] == num) return false;
		}
	
		// 3 x 3 검사
		int startR = (r / 3) * 3;
		int startC = (c / 3) * 3;
		for (int i = startR; i < startR + 3; i++) {
			for (int j = startC; j < startC + 3; j++) {
				if(map[i][j] == num) return false;
			}
		}
		
		return true;
	}
}