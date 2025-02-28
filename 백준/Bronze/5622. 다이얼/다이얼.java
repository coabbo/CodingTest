import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int needTime = 0;
		
		String[] alphabetArr = new String[11];
		alphabetArr[0] = "";
		alphabetArr[1] = "";
		alphabetArr[2] = "ABC";
		alphabetArr[3] = "DEF";
		alphabetArr[4] = "GHI";
		alphabetArr[5] = "JKL";
		alphabetArr[6] = "MNO";
		alphabetArr[7] = "PQRS";
		alphabetArr[8] = "TUV";
		alphabetArr[9] = "WXYZ";
		alphabetArr[10] = "";
		
		String input = br.readLine();
		
		for (int i = 0; i < alphabetArr.length; i++) {
			for (int j = 0; j < alphabetArr[i].length(); j++) {
				for (int k = 0; k < input.length(); k++) {
					if(alphabetArr[i].charAt(j) == input.charAt(k)) {
						needTime += i+1;
					}
				}
			}
		}
		
		System.out.println(needTime);
	}
}