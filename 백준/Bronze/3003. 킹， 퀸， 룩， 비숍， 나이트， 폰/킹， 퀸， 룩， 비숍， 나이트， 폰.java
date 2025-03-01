import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] basicChess = new int[6];
		int[] haveChess = new int[6];
		int[] answerChess = new int[6];
		
		basicChess[0] = 1;
		basicChess[1] = 1;
		basicChess[2] = 2;
		basicChess[3] = 2;
		basicChess[4] = 2;
		basicChess[5] = 8;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < haveChess.length; i++) {
			haveChess[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < basicChess.length; i++) {
			if(basicChess[i] == haveChess[i]) {
				answerChess[i] = 0;
				continue;
			}
			answerChess[i] = basicChess[i] - haveChess[i]; 
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i : answerChess) {
			sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
	}
}