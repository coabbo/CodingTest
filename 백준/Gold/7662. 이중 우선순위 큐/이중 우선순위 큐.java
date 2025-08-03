import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		
		for (int testCase = 1; testCase <= T; testCase++) {
			TreeMap<Integer, Integer> map = new TreeMap<>();
			int k = Integer.parseInt(br.readLine()); // 입력 데이터의 수
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				String order = st.nextToken();
				switch (order) {
					case "I": {
						int n = Integer.parseInt(st.nextToken());	
						map.put(n, map.getOrDefault(n, 0) + 1);
						break;
					}
					case "D": {
						int n = Integer.parseInt(st.nextToken());
						
						if(!map.isEmpty()) {
							if(n == 1) { // 최댓값 삭제
								int max = map.lastKey();
								if(map.get(max) == 1) map.remove(max);
								else map.put(max, map.get(max) - 1);
							}
							else if(n == -1) { // 최솟값 삭제
								int min = map.firstKey();
								if(map.get(min) == 1) map.remove(min);
								else map.put(min, map.get(min) - 1);
							}
						}
						
						break;
					}
				}
			}
			
			if(map.isEmpty()) sb.append("EMPTY").append("\n");
			else sb.append(map.lastKey() + " " + map.firstKey()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}