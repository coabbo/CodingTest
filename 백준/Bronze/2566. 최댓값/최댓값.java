import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] numArr = new int[9][9];
		
		int max = -1;
		int row = -1; //행
		int column = -1; //열
		
		for (int i = 0; i < numArr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < numArr[i].length; j++) {
				numArr[i][j] = Integer.parseInt(st.nextToken());
				if(max < numArr[i][j]) {
					max = numArr[i][j];
					row = i;
					column = j;
				}
			}
		}

		System.out.println(max);
		System.out.println((row+1) + " " + (column+1));
	}
}