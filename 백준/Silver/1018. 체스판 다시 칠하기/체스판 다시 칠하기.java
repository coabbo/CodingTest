import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int row = Integer.parseInt(st.nextToken());
		int column = Integer.parseInt(st.nextToken());
		
		String[] board = new String[row];
		for (int i = 0; i < board.length; i++) {
			board[i] = br.readLine();
		}
		
		//1. 체스판 자르기
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i <= row - 8; i++) {
			for (int j = 0; j <= column - 8; j++) {
				//2. 현 체스판의 최소 비용 구하기
				int currentMinCost = getMinCost(i, j, board);
				//3. 전체 최적의 값과 비교하여 갱신하기
				if(ans > currentMinCost) ans = currentMinCost;
			}
		}
		
		System.out.println(ans);
	}

	public static int getMinCost(int startRow, int startCol, String[] board) {
		String[] orgBoard = {"WBWBWBWB", "BWBWBWBW"};
		int whiteSol = 0;
		for (int i = 0; i < 8; i++) {
			int row = startRow + i;
			for (int j = 0; j < 8; j++) {
				int col = startCol + j;
				if(board[row].charAt(col) != orgBoard[row%2].charAt(j)) {
					whiteSol++;
				}
			}
		}
		
		return Math.min(whiteSol, 64-whiteSol);
	}
}