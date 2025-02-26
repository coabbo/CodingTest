import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] numArr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numArr[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayList<Integer> answerList = new ArrayList<>();
				
		for (int i = 0; i < numArr.length; i++) {
			if(numArr[i] < X) {
				answerList.add(numArr[i]);
			}
		}
		
		for (int i = 0; i < answerList.size(); i++) {
			if(i == answerList.size() - 1) {
				System.out.print(answerList.get(i));
			} else {
				System.out.print(answerList.get(i) + " ");
			}
		}
		
	}
}