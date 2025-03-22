import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 0; testCase < T; testCase++) {
			
			int answer = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int H = Integer.parseInt(st.nextToken()); // 호텔의 층 수
			int W = Integer.parseInt(st.nextToken()); // 각 층의 방 수
			int N = Integer.parseInt(st.nextToken()); // 몇 번째 손님
			
			int count = 0;
			
A:			for (int i = 1; i <= W; i++) {
				for (int j = 1; j <= H; j++) {
					count += 1;
					
					if(count == N) {
						answer = j * 100 + i;
						break A;
					}
				}
			}

			System.out.println(answer);
		}
	}
}