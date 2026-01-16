import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		
		int maxTeam = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int team = 0;
			
			for (int j = 0; j < 3; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				team += a * A + b * B + c * C;
			}
			
			maxTeam = Math.max(maxTeam, team);
		}
		
		System.out.println(maxTeam);
	}
}