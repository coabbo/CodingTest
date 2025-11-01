import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			Set<Integer> set1 = new HashSet<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				set1.add(Integer.parseInt(st.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());	
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				int num = Integer.parseInt(st.nextToken());
				
				if(set1.contains(num)) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}