import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// A의 길이는 B의 길이보다 작거나 같다.
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String A = st.nextToken();
		String B = st.nextToken();

		int lenA = A.length();
		int lenB = B.length();
		
		int answer = Integer.MAX_VALUE;
		
		for (int i = 0; i <= lenB - lenA; i++) {
			int currentDiff = 0;
			
			for (int j = 0; j < lenA; j++) {
				if (A.charAt(j) != B.charAt(i + j)) {
					currentDiff++;
				}
			}
			
			answer = Math.min(currentDiff, answer);
		}
		
		System.out.println(answer);
	}
}