import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] patterns = {"TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT", "HHH"};
		
		int T = Integer.parseInt(br.readLine());		
		for (int testCase = 1; testCase <= T; testCase++) {
			Map<String, Integer> map = new HashMap<>();
			
			String s = br.readLine();
			for (int i = 0; i < s.length() - 2; i++) {
				String temp = s.substring(i, i + 3);
				
				map.put(temp, map.getOrDefault(temp, 0) + 1);
			}
			
			for (int i = 0; i < patterns.length; i++) {
				sb.append(map.getOrDefault(patterns[i], 0)).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}