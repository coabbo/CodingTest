import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int count = 0;
			StringBuilder front = new StringBuilder();
			StringBuilder back = new StringBuilder();
			
			while(st.hasMoreTokens()) {
				if (count == 2) {
					back.append(st.nextToken()).append(" ");
				}
				else {
					front.append(st.nextToken()).append(" ");
					count++;
				}
			}
			
			answer.append(back).append(front).append("\n");
		}
		
		System.out.println(answer.toString());
	}
}