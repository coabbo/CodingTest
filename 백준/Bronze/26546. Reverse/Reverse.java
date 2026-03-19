import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < n; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String s = st.nextToken();
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			sb.append(s.substring(0, i)).append(s.substring(j, s.length())).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}