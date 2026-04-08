import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		int answer = 0;
		
		if (a > 1) answer += 5 * a;
		else answer += 1 * a;
		
		if (b > 1) answer += 5 * b;
		else answer += 1 * b;
		
		if (c > 1) answer += 5 * c;
		else answer += 1 * c;
		
		if (d > 1) answer += 5 * d;
		else answer += 1 * d;
		
		if (e > 1) answer += 5 * e;
		else answer += 1 * e;
		
		if (f > 1) answer += 5 * f;
		else answer += 1 * f;
		
		
		System.out.println(answer);
	}
}