import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		int MAX = 10; // 10까지 미리 계산
		int[] dy = new int[MAX+1];
		dy[1] = 1;
		dy[2] = 2;
		dy[3] = 4; 
		
		for (int i = 4; i <= MAX; i++) {
			dy[i] = dy[i-3] + dy[i-2] + dy[i-1];
		}

		while(T != 0) {
			int N = Integer.parseInt(br.readLine());
			System.out.println(dy[N]);
			T--;
		}
	}
}