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
			int d = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			int parallelize = d + p * n;
			int notPparallelize = s * n;
			
			if (parallelize == notPparallelize) sb.append("does not matter").append("\n");
			else if (parallelize > notPparallelize) sb.append("do not parallelize").append("\n");
			else sb.append("parallelize").append("\n");
		}
		
		System.out.println(sb.toString());
	}
}