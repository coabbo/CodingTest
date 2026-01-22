import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		int P = 10 + 2 * (25 - A + T);
		
		if(P < 0) System.out.println(0);
		else System.out.println(P);
	}
}