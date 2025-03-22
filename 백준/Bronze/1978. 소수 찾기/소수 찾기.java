import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int num[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		
		for (int i = 0; i < num.length; i++) {
			int temp = num[i];
			
			if(temp == 1) {
				continue;
			}
			else if(temp == 2) {
				count += 1;
				continue;
			}
			else {
				for (int j = 2; j < temp; j++) {
					if(temp % j == 0) {
						break;
					}
					if(j == temp-1) {
						count += 1;
					}
				}
			}
		}
		System.out.println(count);
	}
}