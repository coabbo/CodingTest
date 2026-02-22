import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sb.append("Case #").append(i).append(": ");
			
			ArrayDeque<String> q = new ArrayDeque<>();
			while(st.hasMoreTokens()) {
				q.addLast(st.nextToken());
			}
			
			while(!q.isEmpty()) {
				if(q.size() == 1) {
					sb.append(q.remove()).append("\n");
					break;
				}
				
				sb.append(q.removeLast()).append(" ");
			}
		}
		
		System.out.println(sb.toString());
	}
}