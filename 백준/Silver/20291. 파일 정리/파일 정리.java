import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new TreeMap<>(); 
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			int index = s.indexOf('.');
			String extension = s.substring(index + 1);
			
			map.put(extension, map.getOrDefault(extension, 0) + 1);
		}
		
		for (Entry<String, Integer> entry : map.entrySet()) {
			sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
		}
		System.out.println(sb.toString());
	}
}