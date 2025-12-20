import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int H = Integer.parseInt(br.readLine());
		int W = Integer.parseInt(br.readLine());
		
		double R = Math.min(H, W);
		R /= 2;
		
		System.out.println((int)(R * 100));
	}
}