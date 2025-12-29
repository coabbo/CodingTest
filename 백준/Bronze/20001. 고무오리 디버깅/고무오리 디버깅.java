import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String first = br.readLine();
		
		int count = 0;
		while(true) {
			String s = br.readLine();
			
			if(s.equals("고무오리 디버깅 끝")) break;
			
			if(s.equals("문제")) count++;
			else if(s.equals("고무오리")) {
				if(count <= 0) count += 2;
				else count--;
			}
		}
		
		if(count == 0) {
			System.out.println("고무오리야 사랑해");
		}
		else {
			System.out.println("힝구");
		}
	}
}