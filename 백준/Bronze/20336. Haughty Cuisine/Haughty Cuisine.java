import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			
			if(i == n-1) System.out.println(m);
			
			for (int j = 0; j < m; j++) {
				String s = st.nextToken();
				
				if(i == n-1) System.out.println(s);
			}
		}
	}
}