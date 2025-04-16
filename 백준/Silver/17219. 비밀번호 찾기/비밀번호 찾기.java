import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken()); //저장된 사이트 주소의 수
		int M = Integer.parseInt(st.nextToken()); //비밀번호를 찾으려는 사이트 주소의 수
		
		Map<String, String> site = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			String address = st.nextToken();
			String password = st.nextToken();
			
			site.put(address, password);
		}

		for (int i = 0; i < M; i++) {
			String findSite = br.readLine();
			System.out.println(site.get(findSite));
		}
	}
}