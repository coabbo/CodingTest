import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); //바구니
		int M = Integer.parseInt(st.nextToken()); //횟수
		
		int[] numArr = new int[N+1];
		
		for (int p = 0; p < M; p++) {
			st = new StringTokenizer(br.readLine(), " ");
			int i = Integer.parseInt(st.nextToken()); //바구니(i번)
			int j = Integer.parseInt(st.nextToken()); //바구니(j번)
			int k = Integer.parseInt(st.nextToken()); //공 번호
			
			for (; i <= j; i++) {
				numArr[i] = k;
			}
		}
		
		for (int i = 1; i < numArr.length; i++) {
			sb.append(numArr[i]).append(" ");
		}
		
		System.out.print(sb.toString());
	}
}