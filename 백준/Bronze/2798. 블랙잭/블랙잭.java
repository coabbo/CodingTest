import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); // N장의 카드
		int M = Integer.parseInt(st.nextToken()); // 넘지 않는 한도 
		
		int[] card = new int[N];
		
		int Mmax = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < card.length; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i <= N-3; i++) {
			for (int j = i+1; j <= N-2; j++) {
				for (int k = j+1; k <= N-1; k++) {
					
					int sum = card[i] + card[j] + card[k];
					
					if(sum > M) {
						continue;
					}
					
					Mmax = Math.max(sum, Mmax);
				}
			}
		}
		
		System.out.println(Mmax);
	}
}