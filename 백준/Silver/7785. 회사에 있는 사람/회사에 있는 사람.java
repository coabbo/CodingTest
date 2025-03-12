import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		Map<String, String> logMap = new HashMap<>();
	
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			logMap.put(st.nextToken(), st.nextToken());
		}
		
		List<String> strList = new ArrayList<>();
		
		for (Map.Entry<String, String> entry : logMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			
			if(value.equals("leave")) {
				continue;
			}
			
			strList.add(key);
		}
		
		Collections.sort(strList);
		
		for (int i = strList.size()-1; i >= 0 ; i--) {
			sb.append(strList.get(i)).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}