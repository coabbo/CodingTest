import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int count0 = 0;
		int count1 = 0;

		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) count0++;
			else count1++;
		}
		
		if(count0 > count1) System.out.println("Junhee is not cute!");
		else System.out.println("Junhee is cute!");
	}
}