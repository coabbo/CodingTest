import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N1 = Integer.parseInt(st.nextToken());
			int N2 = Integer.parseInt(st.nextToken());
			
			if(N1 == 0 & N2 == 0) {
				break;
			}
			
			if(N1 % N2 == 0) {
				sb.append("multiple").append("\n");
			} else if(N2 % N1 == 0) {
				sb.append("factor").append("\n");
			} else {
				sb.append("neither").append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}