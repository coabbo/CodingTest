import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int F = Integer.parseInt(br.readLine());
		
		String temp  = N.substring(0, N.length() - 2);
		int first = Integer.parseInt(temp + "00");
		int last = Integer.parseInt(temp + "99");
		
		for (int i = first; i <= last; i++) {
			if(i % F == 0) {
				String x = i + "";
				System.out.println(x.substring(x.length() - 2, x.length()));
				
				break;
			}
		}
	}
}