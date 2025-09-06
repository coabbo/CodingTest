import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int Y = Integer.parseInt(br.readLine()); // 막내아이의 나이
		int M = Integer.parseInt(br.readLine()); // 둘째아이의 나이
		
		System.out.println(M + (M-Y));
	}
}