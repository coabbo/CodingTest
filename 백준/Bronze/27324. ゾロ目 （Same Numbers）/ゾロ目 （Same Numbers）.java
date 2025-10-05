import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		char A = N.charAt(0);
		char B = N.charAt(1);
		
		if(A == B) System.out.println("1");
		else System.out.println("0");
	}
}