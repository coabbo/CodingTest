import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			String s = br.readLine();
			int sum = 0;
			
			for (int i = 0; i < s.length(); i++) {
				sum = chronogram(s.charAt(i), sum);
			}
			
			sb.append(sum).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static int chronogram(char c, int sum) {
		switch (c) {
			case 'I': {
				sum += 1;
				break;
			}
			case 'V': {
				sum += 5;
				break;
			}
			case 'X': {
				sum += 10;
				break;
			}
			case 'L': {
				sum += 50;
				break;
			}
			case 'C': {
				sum += 100;
				break;
			}
			case 'D': {
				sum += 500;
				break;
			}
			case 'M': {
				sum += 1000;
				break;
			}
		}
		
		return sum;
	}
}