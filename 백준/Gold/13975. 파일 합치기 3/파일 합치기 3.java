import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			int K = Integer.parseInt(br.readLine());
			
			PriorityQueue<Long> pq = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < K; i++) {
				pq.offer(Long.parseLong(st.nextToken()));
			}

			long answer = 0;
			while (!pq.isEmpty()) {
				long size1 = pq.poll();
				long size2 = pq.poll();
				long bundle = size1 + size2;
				answer += bundle;
				
				if (pq.size() == 0) break;
				else pq.add(bundle);
			}

			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}