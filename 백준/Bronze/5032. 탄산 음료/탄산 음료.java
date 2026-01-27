import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");	
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int temp = e + f;
		int answer = 0;
		
		while(true) {
			int newTemp = temp / c;
			
			if(newTemp == 0) break;
			
			answer += newTemp;
			temp = (temp % c) + newTemp;
		}
		
		System.out.println(answer);
	}
}