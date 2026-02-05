import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(multiply(1, N));
	}

	private static BigInteger multiply(int left, int right) {
		if (left > right) return BigInteger.ONE;
		if (left == right) return BigInteger.valueOf(left);
		if (right - left == 1) return BigInteger.valueOf(left).multiply(BigInteger.valueOf(right));
		
		int mid = (left + right) / 2;
		return multiply(left, mid).multiply(multiply(mid + 1, right));
	}
}