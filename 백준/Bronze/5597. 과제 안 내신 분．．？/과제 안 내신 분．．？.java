import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int[] submit = new int[28];
		
		for (int i = 0; i < submit.length; i++) {
			submit[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(submit);
		
		int[] notSubmit = new int[30];
		int temp = 1;
		for (int i = 0; i < notSubmit.length; i++) {
			notSubmit[i] = temp++;
		}
		
		for (int i = 0; i < notSubmit.length; i++) {
			for (int j = 0; j < submit.length; j++) {
				if(submit[j] == notSubmit[i]) {
					notSubmit[i] = -1;
					break;
				}
			}
		}
		
		for (int i = 0; i < notSubmit.length; i++) {
			if(notSubmit[i] > 0) {
				sb.append(notSubmit[i]).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}