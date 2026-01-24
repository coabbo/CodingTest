import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= N; i++) {
			boolean check = false;
			
			if(i % X == 0 && i % Y == 0) {
				sb.append("FizzBuzz").append("\n");
				check = true;
			}
			else if(i % X == 0) {
				sb.append("Fizz").append("\n");
				check = true;
			}
			else if(i % Y == 0) {
				sb.append("Buzz").append("\n");
				check = true;
			}
			
			if(!check) {
				sb.append(i).append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}