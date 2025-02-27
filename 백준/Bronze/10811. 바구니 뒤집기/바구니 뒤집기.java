import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] numArr = new int[N+1];
		int[] tempArr = new int[N+1];
		
		for (int i = 1; i < numArr.length; i++) {
			numArr[i] = i;
			tempArr[i] = i;
		}
		
		for (int p = 0; p < M; p++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			int temp = j;
			
			for (int q = i; q <= j; q++) {
				numArr[q] = tempArr[temp--]; 
			}
			
			tempArr = Arrays.copyOfRange(numArr, 0, N+1);
		}
		
		for (int p = 1; p < numArr.length; p++) {
			System.out.print(numArr[p] + " ");
		}
	}
}