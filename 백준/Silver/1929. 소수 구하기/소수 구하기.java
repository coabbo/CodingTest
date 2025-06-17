import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = M; i <= N; i++) {
			if (i == 1) continue;
			
			boolean check = true;
			int limit = (int) Math.sqrt(i);
			
			for (int j = 2; j <= limit; j++) {
				if(i % j == 0) {
					check = false;
					break;
				}
			}
			
			if(check) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}