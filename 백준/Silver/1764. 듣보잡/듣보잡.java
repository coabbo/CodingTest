import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); //듣도 못한 사람의 수
		int M = Integer.parseInt(st.nextToken()); //보도 못한 사람의 수
		
		Set<String> NotD = new HashSet<>();
		List<String> NotDB = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			NotD.add(br.readLine());
		}
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			
			if(NotD.contains(s)) {
				NotDB.add(s);
			}
		}

		Collections.sort(NotDB);
		
		sb.append(NotDB.size()).append("\n");
		
		for (String name : NotDB) {
			sb.append(name).append("\n");
		}

		System.out.println(sb.toString());
	}
}