import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int D = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < E; i++) {
			String s = br.readLine();
			
			if (s.equals("+")) D += Integer.parseInt(br.readLine());
			else if (s.equals("-")) D -= Integer.parseInt(br.readLine());
		}
		
		System.out.println(D);
	}
}