import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int N = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			for (int j = 0; j < s.length(); j++) {
				if(j == N - 1) continue;
				
				sb.append(s.charAt(j));
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}