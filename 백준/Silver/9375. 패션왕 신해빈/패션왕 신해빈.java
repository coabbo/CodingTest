import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine()); //테스트케이스 수
		
		for (int testCase = 1; testCase <= tc; testCase++) {
			
			int n = Integer.parseInt(br.readLine()); //해빈이가 가진 의상의 수
			Map<String, Integer> clothesMap = new HashMap<>();
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String name = st.nextToken();
				String type = st.nextToken();
				
				clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
			}
			
			int answer = 1;
			for (int cnt : clothesMap.values()) {
				answer *= (cnt + 1); //입는 경우의 수
			}

			System.out.println(answer - 1); //알몸인 경우 빼기
		}
	}
}