import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(N > 0) {
			
			if(N % 5 == 0) { // N이 5로 나눌수 있으면 5로 나눔
				count += N / 5;
				System.out.println(count);
				return;
			}
			if(N < 3) {
				System.out.println("-1"); // N이 3보다 작으면 N킬로그램을 만들 수 없으므로 -1 출력
				return;
			}
			N = N - 3;
			count++;
		}

		System.out.println(count);
	}
}