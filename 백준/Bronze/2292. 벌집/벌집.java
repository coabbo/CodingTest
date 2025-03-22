import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int room = 0;
		int range = 1;
		int temp = 0;
		
		while(true) {
			if(N == 1) {
				room += 1;
				break;
			}
			if(range >= N) {
				break;
			}
			range += 6 * temp++;
			room += 1;
		}
		
		System.out.println(room);
	}
}