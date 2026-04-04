import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int jinjuC = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String s = st.nextToken();
			int c = Integer.parseInt(st.nextToken());
			
			arr[i] = c;
			
			if (s.equals("jinju")) jinjuC = c;
		}
		
		int count = 0;
		for (int c : arr) {
			if (jinjuC < c) count++;
		}
		
		System.out.println(jinjuC);
		System.out.println(count);
	}
}