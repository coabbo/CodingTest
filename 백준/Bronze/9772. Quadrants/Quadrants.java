import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			if(x > 0 && y > 0) sb.append("Q1").append("\n");
			else if(x < 0 && y > 0) sb.append("Q2").append("\n");
			else if(x < 0 && y < 0) sb.append("Q3").append("\n");
			else if(x > 0 && y < 0) sb.append("Q4").append("\n");
			else if(x == 0 || y == 0) sb.append("AXIS").append("\n");
			
			if(x == 0 && y == 0) {
				break;
			}
		}
		
		System.out.println(sb.toString());
	}
}