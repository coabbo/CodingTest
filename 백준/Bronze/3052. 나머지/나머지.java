import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] numArr = new int[10];
		
		for (int i = 0; i < numArr.length; i++) {
			numArr[i] = Integer.parseInt(br.readLine());
		}
				
		Set<Integer> answerList = new HashSet<>();
		
		for (int i = 0; i < numArr.length; i++) {
			answerList.add(numArr[i] % 42);
		}
		
		sb.append(answerList.size());
		
		System.out.print(sb.toString());		
	}
}