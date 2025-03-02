import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] croatiaAlphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		String input = br.readLine();
		int count = 0;
		
		for (int i = 0; i < input.length();) {
			for (int j = 0; j < croatiaAlphabet.length; j++) {
				if(input.contains(croatiaAlphabet[j])) {
					input = input.replaceFirst(croatiaAlphabet[j], " ");
					count += 1;
					break;
				}
				else if(j == croatiaAlphabet.length - 1) {
					i++;
				}
			}
		}

		input = input.replaceAll(" ", "");
		
		if(input.length() >= 1) {
			for (int i = 0; i < input.length();) {
				input = input.replaceFirst(input.charAt(i)+"", "");
				count += 1;
			}
		}
		
		System.out.println(count);
	}
}