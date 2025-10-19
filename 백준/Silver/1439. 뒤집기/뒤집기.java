import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		int[] count = new int[2];
		
		char c = s.charAt(0);
		if(c == '0') {
			count[0] = 1;
			count[1] = 0;
		}
		else {
			count[0] = 0;
			count[1] = 1;
		}
		
		for (int i = 1; i < s.length(); i++) {
			int before = s.charAt(i - 1) - '0';
			int next = s.charAt(i) - '0';
			
			if(before != next) {
				count[next]++;
			}
		}

		Arrays.sort(count);
		
		System.out.println(count[0]);
	}
}