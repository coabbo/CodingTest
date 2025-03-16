import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	private static int recursionCount;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			String S = br.readLine();
			
			sb.append(isPalindrom(S)).append(" ").append(recursionCount).append("\n");
		}
		
		System.out.println(sb.toString());
	}

	public static int isPalindrom(String S) {
		recursionCount = 0;
		return recursion(S, 0, S.length()-1);
	}

	public static int recursion(String S, int l, int r) {
		++recursionCount;
		
		if(l >= r) {
			return 1;
		}
		else if(S.charAt(l) != S.charAt(r)) {
			return 0;
		}
		else {
			return recursion(S, l+1, r-1);
		}
	}
}