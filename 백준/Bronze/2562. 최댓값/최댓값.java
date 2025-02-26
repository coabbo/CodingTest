import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] numArr = new int[10];
		numArr[0] = -1;
		
		for (int i = 1; i <= 9; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
				
		int max = -1;
		int maxIdx = 0;
		
		for (int i = 1; i <= 9; i++) {
			if(max < numArr[i]) {
				max = numArr[i];
				maxIdx = i;
			}
		}
		
		sb.append(max).append("\n").append(maxIdx);
		
		System.out.println(sb.toString());
	}
}