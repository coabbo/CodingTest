import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int tempN = N;
		int temp = 0;
		
		int cycle = 0;
		while(true) {
			temp = ((tempN / 10 + tempN % 10) % 10) + ((tempN % 10) * 10);
			tempN = temp;
			
			cycle++;
			
			if(N == tempN) {
				System.out.println(cycle);
				break;
			}
			else {
				temp = 0;
			}
		}
	}
}