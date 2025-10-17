import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}
		
		int minCnt = Integer.MAX_VALUE;
		
		for (Integer x : set) {
			int[] candidate = {x, x + 1, x + 2, x + 3, x + 4};
			
			int cnt = 0;
			for (int j = 0; j < candidate.length; j++) {
				if(!set.contains(candidate[j])) {
					cnt++;
				}
			}
			
			minCnt = Math.min(minCnt, cnt);
		}
		
		System.out.println(minCnt);
	}
}