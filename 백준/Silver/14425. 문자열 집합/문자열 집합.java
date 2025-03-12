import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> checkSet = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			checkSet.add(br.readLine());
		}
		
		int count = 0;
		
		for (int i = 0; i < M; i++) {
			if(checkSet.contains(br.readLine())) {
				count++;
			}
		}
	
		sb.append(count);
		
		System.out.println(sb.toString());
	}
}