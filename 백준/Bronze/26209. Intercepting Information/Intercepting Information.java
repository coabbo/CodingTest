import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		String answer = "";
		for (int i = 0; i < 8; i++) {
			int x = Integer.parseInt(st.nextToken());
			
			if(!(x == 0 || x == 1)) {
				answer = "F";
				break;
			}
			else {
				answer = "S";
			}
		}
		
		System.out.println(answer);
	}
}