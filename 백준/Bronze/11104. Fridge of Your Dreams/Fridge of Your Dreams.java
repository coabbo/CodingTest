import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		for (int testCase = 1; testCase <= N; testCase++) {
			String s = br.readLine();
			
			int num = 0;
			for (int i = s.length() - 1; i >= 0; i--) {
				if(s.charAt(i) == '0') continue;
				
				num += Math.pow(2, s.length() - i - 1);
			}
			
			sb.append(num).append("\n");
		}

		System.out.println(sb.toString());
	}
}