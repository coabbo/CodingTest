import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	private static int[][] bingoArr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bingoArr = new int[5][5];
		StringTokenizer st;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				bingoArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = 0;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int currentNum = Integer.parseInt(st.nextToken());
				
a:				for (int p = 0; p < bingoArr.length; p++) {
					for (int q = 0; q < bingoArr[p].length; q++) {
						
						if(bingoArr[p][q] == currentNum) {
							bingoArr[p][q] = 0;
							break a;
						}
					}
				}
				
				int bingoCount = 0;
				bingoCount += rowCount();
				bingoCount += columnCount();
				bingoCount += leftDiagonalCount();
				bingoCount += rightDiagonalCount();
				
				answer++; // 몇 번째에 빙고를 외치는지 카운트
				
				if(bingoCount >= 3) {
					System.out.println(answer);
					return;
				}
			}
		}
	}

	public static int rowCount() { // 행 빙고 개수 카운트
		int bingoTempCount = 0;
		
		for (int i = 0; i < bingoArr.length; i++) {
			int count = 0;
			for (int j = 0; j < bingoArr.length; j++) {
				if(bingoArr[i][j] == 0) {
					count++;
				}
			}
			
			if(count == 5) {
				bingoTempCount++;
			}
		}
		
		return bingoTempCount;
	}
	
	public static int columnCount() { // 열 빙고 개수 카운트
		int bingoTempCount = 0;
		
		for (int i = 0; i < bingoArr.length; i++) {
			int count = 0;
			for (int j = 0; j < bingoArr.length; j++) {
				if(bingoArr[j][i] == 0) {
					count++;
				}
			}
			
			if(count == 5) {
				bingoTempCount++;
			}
		}
		
		return bingoTempCount;
	}
	
	public static int leftDiagonalCount() { // 왼쪽 대각선 빙고 개수 카운트
		int bingoTempCount = 0;
		int count = 0;
		for (int i = 0; i < bingoArr.length; i++) {
			if(bingoArr[i][i] == 0) {
					count++;
			}
		}
		
		if(count == 5) {
			bingoTempCount++;
		}
		
		return bingoTempCount;
	}
	
	public static int rightDiagonalCount() { // 오른쪽 대각선 빙고 개수 카운트
		int bingoTempCount = 0;
		int count = 0;
		for (int i = 0; i < bingoArr.length; i++) {
			int N = bingoArr.length;
			if(bingoArr[i][N-1-i] == 0) {
					count++;
			}
		}
		
		if(count == 5) {
			bingoTempCount++;
		}
		
		return bingoTempCount;
	}
}