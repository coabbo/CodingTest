import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String k = "KOREA";
		
		String s = br.readLine();
		int idx = 0;
		int count = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == k.charAt(idx)) {
				idx++;
				count++;
			}
			
			if(idx == 5) {
				idx = 0;
			}
		}
		
		System.out.println(count);
	}
}