import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int movieName = 666;
		int count = 1;
		
		while(N > count) {
			movieName++;
			
			if(String.valueOf(movieName).contains("666")) {
				count++;
			}
		}
		
		System.out.println(movieName);
	}
}