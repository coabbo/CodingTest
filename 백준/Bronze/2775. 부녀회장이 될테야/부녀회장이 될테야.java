import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine()); //테스트 케이스의 수
		
		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine()); //층수 
			int n = Integer.parseInt(br.readLine()); //호수
			
			int[][] apt = new int[15][15];
			
			for (int ch = 0; ch < apt.length; ch++) {
				int temp = 1;
				int sum = 0;
				for (int ho = 1; ho < apt[ch].length; ho++) {
					if(ch == 0) {
						apt[ch][ho] = temp++;
					} else {
						sum += apt[ch-1][ho];
						apt[ch][ho] = sum;
					}
				}
			}
			
			System.out.println(apt[k][n]);
		}
	}
}