import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		String P = "IOI";
		if(N > 1) {
			for (int i = 1; i < N; i++) {
				P += "OI";
			}
		}
		
		int count = 0;
		for (int i = 0; i < M - P.length() + 1; i++) {
			if(S.substring(i, P.length() + i).equals(P)) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}