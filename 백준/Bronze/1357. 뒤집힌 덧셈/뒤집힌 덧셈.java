import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String x = st.nextToken();
		String y = st.nextToken();

		String rx = "";
		for (int i = x.length() - 1; i >= 0; i--) {
			rx += x.charAt(i);
		}
		
		String ry = "";
		for (int i = y.length() - 1; i >= 0; i--) {
			ry += y.charAt(i);
		}
		
		int sum = Integer.parseInt(rx) + Integer.parseInt(ry);
		
		StringBuilder sb = new StringBuilder();
		sb.append(sum).reverse();
		System.out.println(Integer.parseInt(sb.toString()));
	}
}