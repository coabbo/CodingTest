import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int[] alphabetArr = new int[26];
		
		for (int i = 0; i < alphabetArr.length; i++) {
			alphabetArr[i] = -1;
		}
		
		int count = 0;
		int idx = -1;
		
		for (int i = 0; i < s.length(); i++) {
			idx = s.charAt(i) - 'a';
			if(alphabetArr[idx] == -1) {
				alphabetArr[idx] = count;
			}
			count++;
		}
		
		for (int a : alphabetArr) {
			System.out.print(a + " ");
		}
	}
}