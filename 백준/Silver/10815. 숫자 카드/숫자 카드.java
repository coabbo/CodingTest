import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Set<Integer> sanggenCardSet = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			sanggenCardSet.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			if(sanggenCardSet.contains(Integer.parseInt(st.nextToken()))){
				System.out.print("1 ");
			}
			else {
				System.out.print("0 ");
			}
		}
	}
}