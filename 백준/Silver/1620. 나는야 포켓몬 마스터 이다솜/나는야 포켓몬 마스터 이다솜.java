import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 포켓몬의 개수
		int M = Integer.parseInt(st.nextToken()); // 문제의 개수

		HashMap<Integer, String> indexToNameMap = new HashMap<Integer, String>();
		HashMap<String, Integer> NameToIndexMap = new HashMap<String, Integer>();
		
		for (int i = 1; i < N+1; i++) {
			String name = br.readLine();
			indexToNameMap.put(i, name);
			NameToIndexMap.put(name, i);
		}
		
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			
			if(Character.isDigit(s.charAt(0))) {
				int index = Integer.parseInt(s);
				sb.append(indexToNameMap.get(index)).append("\n");
			}
			else {
				sb.append(NameToIndexMap.get(s)).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}