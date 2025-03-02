import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long anger = 0;
		long currentAnger = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
		
			if(Integer.parseInt(st.nextToken()) == 0) {
				anger += -1;
			} else {
				anger += 1;
			}
			
			currentAnger += anger;
		}
		
		System.out.println(currentAnger);
	}
}