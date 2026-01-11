import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String H = br.readLine();
		String N = br.readLine();
		
		int count = 0;
		for (int i = 0; i < H.length() - N.length() + 1; i++) {
			String temp = H.substring(i, i + N.length());
			
			if(temp.equals(N)) count++;
		}
		
		System.out.println(count);
	}
}