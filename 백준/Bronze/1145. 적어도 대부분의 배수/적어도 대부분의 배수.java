import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		int n3 = Integer.parseInt(st.nextToken());
		int n4 = Integer.parseInt(st.nextToken());
		int n5 = Integer.parseInt(st.nextToken());
		
		int num = Math.min(n1, Math.min(n2, Math.min(n3, Math.min(n4, n5))));
		
		int count = 0;
		while(true) {
			if(num % n1 == 0) count++;
			if(num % n2 == 0) count++;
			if(num % n3 == 0) count++;
			if(num % n4 == 0) count++;
			if(num % n5 == 0) count++;
			
			if(count >= 3) {
				System.out.println(num);
				break;
			}
			else {
				count = 0;
				num++;
			}
		}
	}
}