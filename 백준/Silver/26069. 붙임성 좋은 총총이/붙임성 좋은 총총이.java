import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine()); // 사람들이 만난 기록의 수
		
		Set<String> dancer = new HashSet<>();
		dancer.add("ChongChong");
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String A = st.nextToken();
			String B = st.nextToken();
			
			if(dancer.contains(A) || dancer.contains(B)) {
				dancer.add(A);
				dancer.add(B);
			}
		}
		
		int answer = dancer.size();
		System.out.println(answer);
	}
}