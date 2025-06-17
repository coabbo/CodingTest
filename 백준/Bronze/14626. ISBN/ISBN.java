import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int sum = 0;
		int position = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != '*') {
				if(i % 2 == 0) {
					sum += s.charAt(i) - '0';
				}
				else {
					sum += 3 * (s.charAt(i) - '0');
				}
			}
			else {
				position = i;
			}
		}
		
		int weight = position % 2 == 0 ? 1 : 3;
		for (int i = 0; i <= 9; i++) {
			if((sum + weight * i) % 10 == 0) {
				System.out.println(i);
				break;
			}
		}
	}
}