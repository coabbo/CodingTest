import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean[] arr = new boolean[6];
		for (int i = 0; i < N; i++) {
			int day = Integer.parseInt(br.readLine());
			if (day >= 1 && day <= 5) arr[day] = true;
		}
		
		boolean check = true;
		for (int i = 1; i <= 5; i++) {
			if (!arr[i]) {
				check = false;
				break;
			}
		}
		
		if (check) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
		}
	}
}