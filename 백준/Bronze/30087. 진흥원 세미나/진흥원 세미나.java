import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Map<String, String> map = new HashMap<>();
		map.put("Algorithm", 204 + "");
		map.put("DataAnalysis", 207 + "");
		map.put("ArtificialIntelligence", 302 + "");
		map.put("CyberSecurity", "B101" + "");
		map.put("Network", 303 + "");
		map.put("Startup", 501 + "");
		map.put("TestStrategy", 105 + "");
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			sb.append(map.get(s)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}