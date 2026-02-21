import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String word = st.nextToken();
			String num = st.nextToken();
			
			map.put(num, word);
		}
		
		String s = br.readLine();
		
		for (int i = 0; i < s.length(); i+=4) {
			String temp = s.substring(i, i+4);
			
			if(map.containsKey(temp)) sb.append(map.get(temp));
			else sb.append("?");
		}
		
		System.out.println(sb.toString());
	}
}