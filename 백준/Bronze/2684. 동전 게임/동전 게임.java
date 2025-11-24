import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());		
		for (int testCase = 1; testCase <= T; testCase++) {
			Map<String, Integer> map = new TreeMap<>();
			map.put("TTT", 0); // 뒤뒤뒤
			map.put("TTH", 0); // 뒤뒤앞
			map.put("THT", 0); // 뒤앞뒤
			map.put("THH", 0); // 뒤앞앞
			map.put("HTT", 0); // 앞뒤뒤
			map.put("HTH", 0); // 앞뒤앞
			map.put("HHT", 0); // 앞앞뒤
			map.put("HHH", 0); // 앞앞앞
			
			String s = br.readLine();
			
			for (int i = 0; i < s.length() - 2; i++) {
				String temp = s.substring(i, i + 3);
				
				map.put(temp, map.get(temp) + 1);
			}
			
			List<String> list = new ArrayList<String>(map.keySet());
			Collections.sort(list, Collections.reverseOrder());
			
			for (int i = 0; i < list.size(); i++) {
				sb.append(map.get(list.get(i))).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}