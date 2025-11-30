import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dfs("");
	}

	private static void dfs(String s) {
		int len = s.length();
	
		// 나쁜 수열인지 검사
		for (int size = 1; size <= len/2; size++) {
			if(s.substring(len - size * 2, len - size).equals(s.substring(len - size, len))) {
				return;
			}
		}
		
		// 좋은 수열이면서 길이가 N이면 종료
		if(s.length() == N) {
			System.out.println(s);
			System.exit(0);
		}
		
		for(int i = 1; i <= 3; i++) {
			dfs(s + i);
		}
	}
}