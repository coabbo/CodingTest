import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Integer[] coin = new Integer[N];
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coin, Collections.reverseOrder());
		
		for (int i = 0; i < N; i++) {
			if(K < coin[i]) continue;
			if(K == 0) break;
			
			count += K / coin[i];
			K = K % coin[i];
			
			if(K == 0) break;
		}
		
		System.out.println(count);
	}
}