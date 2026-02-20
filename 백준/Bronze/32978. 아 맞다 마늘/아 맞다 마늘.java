import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Set<String> needSet = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			needSet.add(st.nextToken());
		}
		
		Set<String> useSet = new HashSet<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N-1; i++) {
			useSet.add(st.nextToken());
		}
		
		for (String ingredient : needSet) {
			if(!useSet.contains(ingredient)) {
				System.out.println(ingredient);
				break;
			}
		}
	}
}