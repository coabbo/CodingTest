import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] firstArr = new int[N][M];
		int[][] secondArr = new int[N][M];
		int[][] answerArr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				firstArr[i][j] = Integer.parseInt(st.nextToken());
			}
		} //첫번째 배열 입력
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				secondArr[i][j] = Integer.parseInt(st.nextToken());
			}
		} //두번째 배열 입력
		
		for (int i = 0; i < answerArr.length; i++) {
			for (int j = 0; j < answerArr[i].length; j++) {
				answerArr[i][j] = firstArr[i][j] + secondArr[i][j];
			}
		}
		
		for (int i = 0; i < answerArr.length; i++) {
			for (int j = 0; j < answerArr[i].length; j++) {
				System.out.print(answerArr[i][j] + " ");
			}
			System.out.println("");
		}
	}
}