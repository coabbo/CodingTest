import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		for (int i = 1; i <= N; i++) {
			int temp = 0;
			String s = "" + i;
			for (int j = 0; j < s.length(); j++) {
				temp += s.charAt(j) - '0';
			}
			temp += Integer.parseInt(s);
			if(temp == N) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}