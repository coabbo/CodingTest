import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			int aCount = 0;
			int bCount = 0;
			
			String s = br.readLine();
			for (int j = 0; j < s.length(); j++) {
				if(s.charAt(j) == 'a') aCount++;
				else bCount++;
			}
			
			sb.append(Math.min(aCount, bCount)).append("\n");
		}
	
		System.out.println(sb.toString());
	}
}