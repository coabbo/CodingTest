import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			BigInteger answer = new BigInteger("1");
			BigInteger temp = new BigInteger("1");
			
			if(N == M) {
				sb.append(answer).append("\n");
				continue;
			} else if(N == 1) {
				answer = BigInteger.valueOf(M);
				sb.append(answer).append("\n");
				continue;
			} else {
				for (int j = M; j >= M-N+1; j--) {
					answer = answer.multiply(BigInteger.valueOf(j));
				}
				for (int j = N; j >= 1; j--) {
					temp = temp.multiply(BigInteger.valueOf(j));
				}
				
				answer = answer.divide(temp);
				
				sb.append(answer).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}